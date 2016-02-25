package edu.dartmouth.cs.hci.foodstar.ui.activity;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import edu.dartmouth.cs.hci.foodstar.R;
import edu.dartmouth.cs.hci.foodstar.ui.adapters.ListViewAdapter;

public class RecipeStepsActivity extends ListActivity {

    private static ListView mListView = null;
    private ListViewAdapter mListAdapter = null;
    private static Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_steps);
        mListView = (ListView)findViewById(android.R.id.list);
        //setting the context
        mContext = this;

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        initViews();
    }

    private void initViews() {

        // storing string resources into Array
        String[] recipeSteps = getResources().getStringArray(R.array.recipeSteps);
        String[] stepsNumber = getResources().getStringArray(R.array.stepsNumber);
        Integer imageID = R.drawable.arrow;

        ListViewAdapter adapter = new ListViewAdapter(this, stepsNumber, recipeSteps, imageID);
        mListView.setAdapter(adapter);

        //setting listview listener
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent detailedStepIntent = new Intent(mContext,DetailedStepActivity.class);
                mContext.startActivity(detailedStepIntent);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_home_screen, menu);
        return super.onCreateOptionsMenu(menu);
    }
}