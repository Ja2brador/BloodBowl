package com.example.ja2brador.bloodbowl;

import android.content.Context;
import android.content.res.Resources;
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
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;

import bbsrc.equipos.Equipo;
import bbsrc.jugadores.Jugador;

public class EditTeam extends AppCompatActivity {

    private static Equipo team;
    private LinearLayout skills;
    private TextView value, treasury, bank, addqty, rrqty, totalplayers, niginj, niginjsta, playervalue, playergrow, playerlevel,
            playerexperience, playerrol, playermax;
    private TextView[] atts;
    private CheckBox mng;
    private Button addadd, subadd, newplayer, editplayer, eraseplayer, addgold, subgold, addrr, subrr;
    private ToggleButton apothecary;
    private RadioGroup gold, adds, players;
    private int treasuryint, bankint, valueint, currentplayers, selectedgold, selectedadd, selectedplayer, rerollqty, rrcostint;
    private int[] addqtys, addmaxint, playermaxint;
    private String maxplayers;
    private String[] addmax;
    private ArrayList<Jugador> playerst;
    private Resources res;
    private Context con;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_team);
        initializeViews();
        team = (Equipo) getIntent().getSerializableExtra("team");
        res = getResources();
        con = this;

        rrcostint = team.getPrecioSegundaTirada();
        TextView rrcost = (TextView) findViewById(R.id.rrcostET);
        rrcost.setText(String.valueOf(rrcostint));

        TextView racename = (TextView) findViewById(R.id.nameRaceET);
        racename.setText(team.getNombre() + " (" + getString(team.getRaza()) + ")");

        selectedplayer = -1;
        selectedadd = -1;
        selectedgold = -1;

        treasuryint = team.getTesoro();
        bankint = team.getBanco();
        valueint = team.getValor();
        currentplayers = team.getCantidadPlantilla();
        rerollqty = team.getSegundasTiradas();

        treasury.setText(String.valueOf(treasuryint));
        bank.setText(String.valueOf(bankint));
        value.setText(String.valueOf(valueint));
        rrqty.setText(String.valueOf(rerollqty));

        if (!team.medicoDisponible())
            apothecary.setVisibility(View.GONE);
        else
            apothecary.setChecked(team.getMedico());

        //playermaxint = new int[team.get];

        addqtys = new int[]{team.getFactorHinchas(), team.getAnimadoras(), team.getAsistentes()};
        addmax = new String[]{getString(R.string.maxFF), getString(R.string.maxCheer), getString(R.string.maxAssist)};
        maxplayers = getString(R.string.maxPlayers);

        totalplayers.setText(String.valueOf(currentplayers) + " / " + maxplayers);

        addmaxint = new int[3];
        for (int i = 0; i < 3; i++)
            addmaxint[i] = Integer.valueOf(addmax[i]);

        playerst = team.getPlantilla();
        Jugador jugador;
        for (int i = 0; i < playerst.size(); i++) {
            jugador = playerst.get(i);
            RadioButton rdbtn = new RadioButton(this);
            rdbtn.setId(i + 1);
            rdbtn.setText(jugador.getNombre());
            players.addView(rdbtn);
        }

        radioGroupOnChecked();

        gold.check(R.id.treasuryET);
        adds.check(R.id.fanfactorET);
        players.check(players.getChildAt(0).getId());

    }

    private void radioGroupOnChecked() {
        adds.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup arg0, int selectedId) {
                if (selectedId == -1)
                    return;
                switch (selectedId) {
                    case R.id.fanfactorET:
                        selectedadd = 0;
                        break;
                    case R.id.cheerleadersET:
                        selectedadd = 1;
                        break;
                    case R.id.assistantsET:
                        selectedadd = 2;
                        break;
                }
                if (addqtys[selectedadd] == 0) {
                    subadd.setEnabled(false);
                    addadd.setEnabled(true);
                } else if (addqtys[selectedadd] == addmaxint[selectedadd]) {
                    addadd.setEnabled(false);
                    subadd.setEnabled(true);
                } else {
                    subadd.setEnabled(true);
                    addadd.setEnabled(true);
                }
                addqty.setText(String.valueOf(addqtys[selectedadd]) + " / " + addmax[selectedadd]);
            }
        });
        gold.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int selectedId) {
                if (selectedId == -1)
                    return;
                switch (selectedId) {
                    case R.id.treasuryET:
                        if (treasuryint == 0)
                            subgold.setEnabled(false);
                        else {
                            addgold.setEnabled(true);
                            subgold.setEnabled(true);
                        }
                        break;
                    case R.id.bankET:
                        if (bankint == 200)
                            addgold.setEnabled(false);
                        else if (bankint == 0)
                            subgold.setEnabled(false);
                        else {
                            addgold.setEnabled(true);
                            subgold.setEnabled(true);
                        }
                }
                selectedgold = selectedId;
            }
        });
        players.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int selectedId) {
                if (selectedId == -1)
                    return;
                selectedplayer = selectedId - 1;
                Jugador jug = playerst.get(selectedplayer);

                playervalue.setText(String.valueOf(jug.getPrecio()));
                playergrow.setText(jug.getCrecimiento());
                playerlevel.setText(String.valueOf(jug.getNivel()));

                String exp = jug.getExperiencia() + " / " + jug.getExperienciaSiguienteNivel();
                playerexperience.setText(exp);

                niginj.setText(String.valueOf(jug.getLesionesPermanentes()));

                mng.setChecked(jug.getLPPE());


                playerrol.setText(jug.getJugador());

                int[] attsint = jug.getAtributos();
                int[] color = jug.coloresAtributo();
                TextView tv;
                for (int i = 0; i < 4; i++) {
                    tv = atts[i];
                    tv.setText(String.valueOf(attsint[i]));
                    tv.setTextColor(color[i]);
                }
                String[] skill = res.getStringArray(jug.getHabilidades().getArray());
                skills.removeAllViews();
                for (String sk : skill) {
                    tv = new TextView(con);
                    tv.setText(sk);
                    tv.setGravity(Gravity.CENTER);
                    skills.addView(tv);
                }

            }
        });
    }

    private void initializeViews() {

        value = (TextView) findViewById(R.id.valueET);
        treasury = (TextView) findViewById(R.id.treasurytextET);
        bank = (TextView) findViewById(R.id.banktextET);
        addqty = (TextView) findViewById(R.id.addQtyET);
        rrqty = (TextView) findViewById(R.id.rerollET);
        totalplayers = (TextView) findViewById(R.id.totalplayersET);
        playervalue = (TextView) findViewById(R.id.playervalueET);
        playergrow = (TextView) findViewById(R.id.playergrowET);
        playerrol = (TextView) findViewById(R.id.roleET);
        playerlevel = (TextView) findViewById(R.id.playerlevelET);
        playerexperience = (TextView) findViewById(R.id.experienceET);
        niginj = (TextView) findViewById(R.id.nigglinginjuryET);

        atts = new TextView[]{(TextView) findViewById(R.id.movementET), (TextView) findViewById(R.id.strengthET),
                (TextView) findViewById(R.id.agilityET), (TextView) findViewById(R.id.armorvalueET)};

        mng = (CheckBox) findViewById(R.id.mngET);

        skills = (LinearLayout) findViewById(R.id.playerskillsET);

        addadd = (Button) findViewById(R.id.addAddET);
        subadd = (Button) findViewById(R.id.subAddET);
        newplayer = (Button) findViewById(R.id.newplayerbuttonET);
        editplayer = (Button) findViewById(R.id.editplayerbuttonET);
        eraseplayer = (Button) findViewById(R.id.eraseplayerbuttonET);
        addgold = (Button) findViewById(R.id.addGoldET);
        subgold = (Button) findViewById(R.id.subGoldET);
        addrr = (Button) findViewById(R.id.addRerollET);
        subrr = (Button) findViewById(R.id.subRerollET);

        apothecary = (ToggleButton) findViewById(R.id.apothecaryET);

        gold = (RadioGroup) findViewById(R.id.goldET);
        adds = (RadioGroup) findViewById(R.id.addsradiogroupET);
        players = (RadioGroup) findViewById(R.id.playersradiogroupET);

    }

    public void addReroll(View view) {
        rerollqty++;
        if (rerollqty == 8)
            addrr.setEnabled(false);
        subrr.setEnabled(true);
        rrqty.setText(String.valueOf(rerollqty));
        setValue(rrcostint);
    }

    public void subReroll(View view) {
        rerollqty--;
        if (rerollqty == 0)
            subrr.setEnabled(false);
        addrr.setEnabled(true);
        rrqty.setText(String.valueOf(rerollqty));
        setValue(-rrcostint);
    }

    public void addAdd(View view) {
        addqtys[selectedadd]++;
        addqty.setText(String.valueOf(addqtys[selectedadd]) + " / " + addmax[selectedadd]);
        setValue(10);
        resetAdd();
    }

    public void subAdd(View view) {
        addqtys[selectedadd]--;
        addqty.setText(String.valueOf(addqtys[selectedadd]) + " / " + addmax[selectedadd]);
        setValue(-10);
        resetAdd();
    }

    private void resetAdd() {
        int id = adds.getCheckedRadioButtonId();
        adds.clearCheck();
        adds.check(id);
    }

    public void addGold(View view) {
        setGold(selectedgold, 10);
        resetGold();
    }

    public void subGold(View view) {
        setGold(selectedgold, -10);
        resetGold();
    }

    private void resetGold() {
        gold.clearCheck();
        gold.check(selectedgold);
    }

    private void setGold(int id, int change) {
        int value = 0;
        TextView res = null;
        switch (id) {
            case R.id.treasuryET:
                res = treasury;
                treasuryint += change;
                value = treasuryint;
                setValue(change);
                break;
            case R.id.bankET:
                res = bank;
                bankint += change;
                value = bankint;
                break;
        }
        res.setText(String.valueOf(value));
    }

    public void apothecary(View view) {
        if (apothecary.isChecked())
            setValue(50);
        else
            setValue(-50);
    }

    private void setValue(int change) {
        valueint += change;
        value.setText(String.valueOf(valueint));
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

}
