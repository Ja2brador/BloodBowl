package com.example.ja2brador.bloodbowl;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class EditPlayer extends AppCompatActivity {

    private Button normalsk, doublesk, erasesk, addM, subM, addS, subS, addAG, subAG, addAV, subAV, addni, subni;
    private TextView m, s, ag, av, ni, value, level;
    private RadioGroup xskills;
    private int intm, ints, intag, intav, cost, levelint, intni, mcost, scost, agcost, avcost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_player);
        initializeViews();
    }

    private void initializeViews() {
        m = (TextView) findViewById(R.id.movementEP);
        s = (TextView) findViewById(R.id.strengthEP);
        ag = (TextView) findViewById(R.id.agilityEP);
        av = (TextView) findViewById(R.id.armorvalueEP);
        ni = (TextView) findViewById(R.id.nigglinginjuryEP);
        value = (TextView) findViewById(R.id.valueEP);
        level = (TextView) findViewById(R.id.levelEP);
        normalsk = (Button) findViewById(R.id.normalSkillEP);
        doublesk = (Button) findViewById(R.id.doubleSkillEP);
        erasesk = (Button) findViewById(R.id.eraseSkillEP);
        addM = (Button) findViewById(R.id.addmovementEP);
        subM = (Button) findViewById(R.id.submovementEP);
        addS = (Button) findViewById(R.id.addstrengthEP);
        subS = (Button) findViewById(R.id.substrengthEP);
        addAG = (Button) findViewById(R.id.addagilityEP);
        subAG = (Button) findViewById(R.id.subagilityEP);
        addAV = (Button) findViewById(R.id.addarmorvalueEP);
        subAV = (Button) findViewById(R.id.subarmorvalueEP);
        addni = (Button) findViewById(R.id.addniEP);
        subni = (Button) findViewById(R.id.subniEP);
        xskills = (RadioGroup) findViewById(R.id.learntSkillsEP);
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

    public void addNormalSkill(View view) {
        RadioButton rb = new RadioButton(this);
        xskills.addView(rb);
    }

    public void addDoubleSkill(View view) {
        RadioButton rb = new RadioButton(this);
        xskills.addView(rb);
    }

    public void eraseSkill(View view) {
        levelint--;
        xskills.removeViewAt(xskills.getCheckedRadioButtonId() - 1);
    }

    public void addM(View view) {
        intm++;
        cost += mcost;
    }

    public void subM(View view) {
        intm--;
    }

    public void addS(View view) {
        ints++;
        cost += scost;
    }

    public void subS(View view) {
        ints--;
    }

    public void addAG(View view) {
        intag++;
        cost += agcost;
    }

    public void subAG(View view) {
        intag--;
    }

    public void addAV(View view) {
        intav++;
        cost += avcost;
    }

    public void subAV(View view) {
        intav--;
    }

}
