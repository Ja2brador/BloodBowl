package com.example.ja2brador.bloodbowl;


import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import bbsrc.equipos.Equipo;
import bbsrc.razas.Humano;
import bbsrc.razas.Khorne;
import bbsrc.razas.Orco;

public class CreateTeamMenu extends AppCompatActivity {

    private Resources res;
    private Button finishbtn;
    private ToggleButton apothecarybtn;
    private TypedArray skillsid;
    private EditText playername, teamname;
    private TextView rrcost, rrquantity, playeratt, playergrow, playerqty, totalplayerqty, addsqty, treasury, playercost;
    private LinearLayout playerskill, apothecary;
    private Spinner spinnerraces;
    private RadioGroup players, adds;
    private Boolean apothecarybool;
    private String[][] playersavednames, skills;
    private String[] playernames, playeratts, playergrows, playermaxs, playercosts, maxaddstr;
    private String rrcoststr, totalplayers;
    private int[] playerqtys, addsqtys, intplayercosts, addsmax;
    private int playerselected, currentplayers, selectedplayercost, intrrcost, selectedplayermax,
            treasuryint, addindex, rrqty, selectedrace, totalplayersint, intapothecary;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_team_menu);
        res = getResources();
        totalplayers = getString(R.string.maxPlayers);
        totalplayersint = Integer.valueOf(totalplayers);
        maxaddstr = new String[]{getString(R.string.maxFF), getString(R.string.maxCheer), getString(R.string.maxAssist)};
        addsmax = new int[]{Integer.valueOf(maxaddstr[0]), Integer.valueOf(maxaddstr[1]), Integer.valueOf(maxaddstr[2])};
        intapothecary = Integer.valueOf(getString(R.string.apothecaryCost));
        initializeViews();
        onSelectedAddRG();
        onSelectedRaceSP();
        onCheckedPlayerRG();
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

    private void initializeViews() {

        apothecarybtn = (ToggleButton) findViewById(R.id.medicCTM);
        finishbtn = (Button) findViewById(R.id.buttonFinishCTM);
        playercost = (TextView) findViewById(R.id.playerCostCTM);
        players = (RadioGroup) findViewById(R.id.playersCTM);
        adds = (RadioGroup) findViewById(R.id.addsRadioGroupCTM);
        rrcost = (TextView) findViewById(R.id.rerollPriceCTM);
        rrquantity = (TextView) findViewById(R.id.rerollQuantityCTM);
        addsqty = (TextView) findViewById(R.id.addsQtyCTM);
        teamname = (EditText) findViewById(R.id.teamNameCTM);
        playername = (EditText) findViewById(R.id.playerNameCTM);
        spinnerraces = (Spinner) findViewById(R.id.spinnerRaces);
        treasury = (TextView) findViewById(R.id.treasuryCTM);
        apothecary = (LinearLayout) findViewById(R.id.apothecaryCTM);
        totalplayerqty = (TextView) findViewById(R.id.totalPlayersQtyCTM);
        playeratt = (TextView) findViewById(R.id.playerAttsCTM);
        playergrow = (TextView) findViewById(R.id.playerGrowCTM);
        playerqty = (TextView) findViewById(R.id.playerQtyCTM);
        playerskill = (LinearLayout) findViewById(R.id.playerSkillsCTM);

    }

    private void setTotalPlayer() {
        totalplayerqty.setText(String.valueOf(currentplayers) + " / " + totalplayers);
    }

    private void setSelectedPlayer() {
        playerqty.setText(String.valueOf(playerqtys[playerselected]) + " / " + selectedplayermax);
    }

    private void setTreasury() {
        treasury.setText(String.valueOf(treasuryint));
    }

    private void setAdd() {
        addsqty.setText(addsqtys[addindex] + " / " + maxaddstr[addindex]);
    }

    private void onCheckedPlayerRG() {

        players.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup arg0, int selectedId) {

                if (selectedId == -1)
                    return;
                playerskill.removeAllViews();
                playerselected = selectedId - 1;
                selectedplayercost = Integer.valueOf(playercosts[playerselected]);
                playercost.setText(String.valueOf(selectedplayercost));
                playeratt.setText(playeratts[playerselected]);
                playergrow.setText(playergrows[playerselected]);
                selectedplayermax = Integer.valueOf(playermaxs[playerselected]);
                playerqty.setText(String.valueOf(playerqtys[playerselected]) + " / " + playermaxs[playerselected]);
                for (String skill : skills[playerselected]) {
                    TextView sk = new TextView(getApplicationContext());
                    sk.setText(skill);
                    sk.setGravity(Gravity.CENTER);
                    playerskill.addView(sk);
                }

            }

        });

    }

    private void onSelectedRaceSP() {

        spinnerraces.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                apothecarybtn.setChecked(false);
                apothecarybool = false;
                currentplayers = 0;
                treasuryint = 1000;
                rrqty = 0;
                setTreasury();
                setTotalPlayer();
                rrcoststr = "";
                skillsid = null;
                apothecary.setVisibility(View.VISIBLE);
                selectedrace = pos;
                int n;
                switch (pos) {
                    case 0:
                        assignTeamValues(R.array.humanValues);
                        break;
                    case 1:
                        assignTeamValues(R.array.khorneValues);
                        break;
                    case 2:
                        assignTeamValues(R.array.orcValues);
                        break;
                }
                n = skillsid.length();
                intrrcost = Integer.valueOf(rrcoststr);
                rrcost.setText(rrcoststr);
                playerqtys = new int[n];
                playersavednames = new String[n][];
                addsqtys = new int[3];
                skills = new String[n][];
                intplayercosts = new int[n];
                for (int i = 0; i < n; ++i) {
                    skills[i] = res.getStringArray(skillsid.getResourceId(i, 0));
                    playersavednames[i] = new String[Integer.valueOf(playermaxs[i])];
                    intplayercosts[i] = Integer.valueOf(playercosts[i]);
                }
                if (skillsid != null)
                    skillsid.recycle();
                int i = 1;
                players.removeAllViews();
                for (String playerrol : playernames) {
                    RadioButton rdbtn = new RadioButton(getApplicationContext());
                    rdbtn.setId(i++);
                    rdbtn.setText(playerrol);
                    players.addView(rdbtn);
                }
                adds.check(R.id.ffRadioButtonCTM);
                rrquantity.setText("0");
                treasury.setText(String.valueOf(treasuryint));
                players.clearCheck();
                ((RadioButton) players.getChildAt(0)).setChecked(true);
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }

        });
    }

    private void onSelectedAddRG() {

        adds.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup arg0, int selectedId) {

                switch (selectedId) {
                    case R.id.ffRadioButtonCTM:
                        addindex = 0;
                        break;
                    case R.id.cheerRadioButtonCTM:
                        addindex = 1;
                        break;
                    case R.id.assistRadioButtonCTM:
                        addindex = 2;
                        break;
                }
                setAdd();

            }

        });

    }

    private void assignTeamValues(int id) {

        TypedArray ids = res.obtainTypedArray(id);

        rrcoststr = getString(ids.getResourceId(0, 0));
        skillsid = res.obtainTypedArray(ids.getResourceId(1, 0));
        playernames = res.getStringArray(ids.getResourceId(2, 0));
        playeratts = res.getStringArray(ids.getResourceId(3, 0));
        playergrows = res.getStringArray(ids.getResourceId(4, 0));
        playermaxs = res.getStringArray(ids.getResourceId(5, 0));
        playercosts = res.getStringArray(ids.getResourceId(6, 0));
        ids.recycle();

    }

    public void addPlayer(View view) {
        if (selectedplayercost <= treasuryint && playerqtys[playerselected] < selectedplayermax && currentplayers < totalplayersint) {
            /*String playername = this.playername.getText().toString();
            if(playername.equals("")){
                Toast t = Toast.makeText(this, getString(R.string.emptyNameCTM), Toast.LENGTH_SHORT);
                t.setGravity(Gravity.CENTER, 0, 0);
                t.show();
                return;
            }*/
            playersavednames[playerselected][playerqtys[playerselected]] = this.playername.getText().toString();
            this.playername.setText("");
            currentplayers++;
            if (currentplayers > 10)
                finishbtn.setEnabled(true);
            setTotalPlayer();
            treasuryint -= selectedplayercost;
            setTreasury();
            playerqtys[playerselected]++;
            setSelectedPlayer();
        }
    }

    public void subPlayer(View view) {
        if (playerqtys[playerselected] > 0) {
            playersavednames[playerselected][--playerqtys[playerselected]] = null;
            currentplayers--;
            if (currentplayers < 11)
                finishbtn.setEnabled(false);
            setTotalPlayer();
            treasuryint += selectedplayercost;
            setTreasury();
            setSelectedPlayer();
        }
    }

    public void addAdd(View view) {
        if (treasuryint > 0 && addsqtys[addindex] < addsmax[addindex]) {
            treasuryint -= 10;
            setTreasury();
            addsqtys[addindex]++;
            setAdd();
        }
    }

    public void subAdd(View view) {
        if (addsqtys[addindex] > 0) {
            treasuryint += 10;
            setTreasury();
            addsqtys[addindex]--;
            setAdd();
        }
    }

    public void addReroll(View view) {
        if (intrrcost <= treasuryint && rrqty < 8) {
            rrquantity.setText(String.valueOf(++rrqty));
            treasuryint -= intrrcost;
            setTreasury();
        }
    }

    public void subReroll(View view) {
        if (rrqty > 0) {
            rrquantity.setText(String.valueOf(--rrqty));
            treasuryint += intrrcost;
            setTreasury();
        }
    }

    public void apothecary(View view) {
        apothecarybool = apothecarybtn.isChecked();
        if (!apothecarybool) {
            treasuryint += intapothecary;
            setTreasury();
        } else if (treasuryint >= intapothecary) {
            treasuryint -= intapothecary;
            setTreasury();
        } else {
            apothecarybool = false;
            apothecarybtn.setChecked(false);
        }
    }

    public void checkNames(View view) {
        String names = "";
        String player;
        String playername;
        for (int i = 0; i < playerqtys.length; i++) {
            playername = "";
            player = playernames[i];
            for (int j = 0; j < playersavednames[i].length; j++)
                if (playersavednames[i][j] != null)
                    playername += "\n\t" + playersavednames[i][j];
            if (!playername.equals("")) {
                player += playername;
                names += player + "\n";
            }
        }
        if (!names.equals(""))
            Toast.makeText(this, names, Toast.LENGTH_LONG).show();
    }

    public void finish(View view) {
        String name = teamname.getText().toString();
        if (name.equals("")) {
            Toast t = Toast.makeText(this, getString(R.string.emptyTeamNameCTM), Toast.LENGTH_SHORT);
            t.setGravity(Gravity.CENTER, 0, 0);
            t.show();
            return;
        }
        Equipo newteam;
        switch (selectedrace) {
            case 0:
                newteam = new Humano(name, treasuryint, addsqtys[0], addsqtys[1], addsqtys[2], apothecarybool, rrqty);
                break;
            case 1:
                newteam = new Khorne(name, treasuryint, addsqtys[0], addsqtys[1], addsqtys[2], apothecarybool, rrqty);
                break;
            case 2:
                newteam = new Orco(name, treasuryint, addsqtys[0], addsqtys[1], addsqtys[2], apothecarybool, rrqty);
                break;
            default:
                newteam = null;
        }

        int qty;
        for (int i = 0; i < playerqtys.length; i++) {
            qty = playerqtys[i];
            for (int j = 0; j < qty; j++) {
                assert newteam != null;
                newteam.anadirJugador(i, playersavednames[i][j], playernames[i], intplayercosts[i]);
            }
        }

        MainMenu.getEquipos().add(newteam);
        finish();
    }

    public void onStop() {
        super.onStop();
        MainMenu.guardarEquipos();
    }

}
