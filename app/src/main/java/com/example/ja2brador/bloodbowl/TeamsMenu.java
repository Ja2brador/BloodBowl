package com.example.ja2brador.bloodbowl;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;

import bbsrc.equipos.Equipo;
import bbsrc.jugadores.Jugador;

public class TeamsMenu extends AppCompatActivity {

    private RadioGroup teams, playersrg;
    private LinearLayout detail, skills, teamdetails, niginjLL;
    private ScrollView attschanges;
    private ArrayList<Equipo> equipos;
    private Button erase, edit;
    private ToggleButton details;
    private TextView race, value, players, reroll, treasury, bank, ff, assist, cheer, role, cost, level, exp, grow, niginj;
    private TextView[] atts, attchange;
    private CheckBox apothecary, missnextgame;
    private Equipo selected;
    private int selectedteam, eraseteam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams_menu);
        selectedteam = 1;
        initializeViews();
        onCheckedTeamRG();
        onCheckedPlayerRG();
        setEnabledButtons(false);
        Equipo equipo;
        equipos = MainMenu.getEquipos();
        for (int i = 0; i < equipos.size(); i++) {
            equipo = equipos.get(i);
            RadioButton rdbtn = new RadioButton(this);
            rdbtn.setId(i + 1);
            rdbtn.setText(equipo.getNombre());
            teams.addView(rdbtn);
        }
        if (teams.getChildCount() > 0) {
            teamdetails.setVisibility(View.VISIBLE);
            teams.check(teams.getChildAt(0).getId());
        }
    }

    public void onResume() {
        super.onResume();
        Equipo equipo;
        int childcount = teams.getChildCount();
        for (int i = childcount; i < equipos.size(); i++) {
            equipo = equipos.get(i);
            RadioButton rdbtn = new RadioButton(this);
            rdbtn.setId(i + 1);
            rdbtn.setText(equipo.getNombre());
            teams.addView(rdbtn);
        }
        if (childcount < teams.getChildCount()) {
            teams.clearCheck();
            teams.check(teams.getChildAt(0).getId());
        }
    }

    public void editTeam(View view) {

        Intent myIntent = new Intent(this, EditTeam.class);
        myIntent.putExtra("team", selected);
        startActivity(myIntent);

    }

    public void eraseTeam(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder
                .setMessage(R.string.eraseMessageTM)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        eraseteam = selectedteam - 1;
                        equipos.remove(eraseteam);
                        teams.removeViewAt(eraseteam);
                        teams.clearCheck();
                        if (teams.getChildCount() == 0) {
                            setEnabledButtons(false);
                            teamdetails.setVisibility(View.GONE);
                        } else {
                            int childcount = teams.getChildCount();
                            for (int i = eraseteam; i < childcount; i++) {
                                RadioButton rb = (RadioButton) teams.getChildAt(i);
                                rb.setId(i + 1);
                            }
                            if (selectedteam == childcount)
                                eraseteam--;
                            teams.check(eraseteam);
                        }
                        details.setChecked(false);
                        detail.setVisibility(View.INVISIBLE);
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                })
                .setCancelable(false);

        AlertDialog dialog = builder.create();

        dialog.show();

    }

    public void details(View view) {
        if (details.isChecked())
            detail.setVisibility(View.VISIBLE);
        else
            detail.setVisibility(View.INVISIBLE);
    }

    private void onCheckedTeamRG() {

        teams.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup arg0, int selectedId) {
                selectedteam = selectedId;
                if (selectedId == -1)
                    return;
                if (selectedId == 0) {
                    teamdetails.setVisibility(View.GONE);
                    return;
                }
                setEnabledButtons(true);
                teamdetails.setVisibility(View.VISIBLE);
                selected = equipos.get(selectedteam - 1);
                apothecary.setVisibility(View.VISIBLE);
                race.setText(getString(selected.getRaza()));
                value.setText(String.valueOf(selected.getValor()));
                players.setText(String.valueOf(selected.getCantidadPlantilla()) + " / " + getString(R.string.maxPlayers));
                reroll.setText(String.valueOf(selected.getSegundasTiradas()) + " / " + getString(R.string.maxRR));
                treasury.setText(String.valueOf(selected.getTesoro()));
                bank.setText(String.valueOf(selected.getBanco()));
                ff.setText(String.valueOf(selected.getFactorHinchas()) + " / " + getString(R.string.maxFF));
                assist.setText(String.valueOf(selected.getAsistentes()) + " / " + getString(R.string.maxAssist));
                cheer.setText(String.valueOf(selected.getAnimadoras()) + " / " + getString(R.string.maxCheer));
                if (selected.medicoDisponible())
                    apothecary.setChecked(selected.getMedico());
                else
                    apothecary.setVisibility(View.GONE);
                playersrg.clearCheck();
                playersrg.removeAllViews();
                ArrayList<Jugador> plantilla = selected.getPlantilla();
                Jugador jugador;
                Context th = getApplicationContext();
                for (int i = 0; i < plantilla.size(); i++) {
                    jugador = plantilla.get(i);
                    RadioButton rdbtn = new RadioButton(th);
                    rdbtn.setId(i + 1);
                    rdbtn.setText(jugador.getNombre());
                    playersrg.addView(rdbtn);
                }
                playersrg.check(playersrg.getChildAt(0).getId());
            }

        });

    }

    private void onCheckedPlayerRG() {
        playersrg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup arg0, int selectedId) {
                if (selectedId == -1)
                    return;
                Jugador jugador = selected.getJugador(selectedId - 1);
                role.setText(jugador.getJugador());
                level.setText(String.valueOf(jugador.getNivel()));
                cost.setText(String.valueOf(jugador.getPrecio()));
                exp.setText(String.valueOf(jugador.getExperiencia()) + " / " + String.valueOf(jugador.getExperienciaSiguienteNivel()));
                int niginjint = jugador.getLesionesPermanentes();
                if (niginjint > 0)
                    niginj.setText(String.valueOf(niginjint));
                else
                    niginjLL.setVisibility(View.GONE);
                missnextgame.setChecked(jugador.getLPPE());
                grow.setText(jugador.getCrecimiento());
                int[] attsint = jugador.getAtributos();
                int[] colores = jugador.coloresAtributo();
                for (int i = 0; i < 4; i++) {
                    TextView tv = atts[i];
                    tv.setText(String.valueOf(attsint[i]));
                    tv.setTextColor(colores[i]);
                }
                int[] sk = jugador.getHabilidades().getIdHabilidades();
                Context th = getApplicationContext();
                skills.removeAllViews();
                for (int i = 0; i < sk.length; i++) {
                    TextView newtx = new TextView(th);
                    newtx.setText(sk[i]);
                    newtx.setGravity(Gravity.CENTER);
                    skills.addView(newtx);
                }
            }
        });
    }

    private void setEnabledButtons(boolean enable) {
        erase.setEnabled(enable);
        edit.setEnabled(enable);
        details.setEnabled(enable);
        int color = erase.getCurrentTextColor();
        details.setTextColor(color);
    }

    private void initializeViews() {
        detail = (LinearLayout) findViewById(R.id.detailsLayoutTM);
        race = (TextView) findViewById(R.id.raceTM);
        value = (TextView) findViewById(R.id.valueTM);
        players = (TextView) findViewById(R.id.playersQtyTM);
        reroll = (TextView) findViewById(R.id.rerollTM);
        treasury = (TextView) findViewById(R.id.treasuryTM);
        bank = (TextView) findViewById(R.id.bankTM);
        ff = (TextView) findViewById(R.id.ffTM);
        assist = (TextView) findViewById(R.id.assistantsTM);
        cheer = (TextView) findViewById(R.id.cheerleadersTM);
        apothecary = (CheckBox) findViewById(R.id.apothecaryTM);
        playersrg = (RadioGroup) findViewById(R.id.playersTM);
        teams = (RadioGroup) findViewById(R.id.teamsTM);
        erase = (Button) findViewById(R.id.eraseTM);
        edit = (Button) findViewById(R.id.editTM);
        details = (ToggleButton) findViewById(R.id.detailsTM);
        teamdetails = (LinearLayout) findViewById(R.id.teamDetailsTM);
        niginjLL = (LinearLayout) findViewById(R.id.nigingllTM);

        skills = (LinearLayout) findViewById(R.id.playerskillsTM);
        attschanges = (ScrollView) findViewById(R.id.playerattchangesTM);
        role = (TextView) findViewById(R.id.roleTM);
        cost = (TextView) findViewById(R.id.costTM);
        level = (TextView) findViewById(R.id.levelTM);
        exp = (TextView) findViewById(R.id.expTM);
        atts = new TextView[]{
                (TextView) findViewById(R.id.movementTM),
                (TextView) findViewById(R.id.strengthTM),
                (TextView) findViewById(R.id.agilityTM),
                (TextView) findViewById(R.id.armorvalueTM)
        };
        attchange = new TextView[]{
                (TextView) findViewById(R.id.movementchangeTM),
                (TextView) findViewById(R.id.strengthchangeTM),
                (TextView) findViewById(R.id.agilitychangeTM),
                (TextView) findViewById(R.id.armorvaluechangeTM)
        };
        grow = (TextView) findViewById(R.id.growTM);
        niginj = (TextView) findViewById(R.id.nigglingInjuryTM);
        missnextgame = (CheckBox) findViewById(R.id.missNextGameTM);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        return super.onOptionsItemSelected(item);
    }

    public void createTeam(View view) {
        Intent i = new Intent(this, CreateTeamMenu.class);
        startActivity(i);
    }

    public void onStop() {
        super.onStop();
        MainMenu.guardarEquipos();
    }

}
