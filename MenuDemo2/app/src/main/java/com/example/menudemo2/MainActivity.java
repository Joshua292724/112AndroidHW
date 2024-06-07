package com.example.menudemo2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Spinner categorySpinner;
    private ListView itemListView;
    private TextView mainCourseSelection, sideDishSelection, drinksSelection;
    private Button confirmButton, cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        categorySpinner = findViewById(R.id.category_spinner);
        itemListView = findViewById(R.id.item_listview);
        mainCourseSelection = findViewById(R.id.main_course_selection);
        sideDishSelection = findViewById(R.id.side_dish_selection);
        drinksSelection = findViewById(R.id.drinks_selection);
        confirmButton = findViewById(R.id.confirm_button);
        cancelButton = findViewById(R.id.cancel_button);


        ArrayAdapter<CharSequence> categoryAdapter = ArrayAdapter.createFromResource(this,
                R.array.category_array, android.R.layout.simple_spinner_item);
        categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorySpinner.setAdapter(categoryAdapter);

        categorySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int arrayResId;
                if (position == 0) {
                    arrayResId = R.array.main_course_array;
                } else if (position == 1) {
                    arrayResId = R.array.side_dish_array;
                } else if (position == 2) {
                    arrayResId = R.array.drinks_array;
                } else {
                    arrayResId = R.array.main_course_array;
                }

                String[] items = getResources().getStringArray(arrayResId);
                ArrayAdapter<String> itemAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, items);
                itemListView.setAdapter(itemAdapter);


                itemListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String selectedItem = parent.getItemAtPosition(position).toString();
                        int categoryPosition = categorySpinner.getSelectedItemPosition();
                        if (categoryPosition == 0) {
                            mainCourseSelection.setText(selectedItem);
                        } else if (categoryPosition == 1) {
                            sideDishSelection.setText(selectedItem);
                        } else if (categoryPosition == 2) {
                            drinksSelection.setText(selectedItem);
                        }
                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("mainCourse", mainCourseSelection.getText().toString());
                intent.putExtra("sideDish", sideDishSelection.getText().toString());
                intent.putExtra("drinks", drinksSelection.getText().toString());
                startActivity(intent);
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainCourseSelection.setText("請選擇");
                sideDishSelection.setText("請選擇");
                drinksSelection.setText("請選擇");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.action_submit) {
            // Handle submit action
            return true;
        } else if (itemId == R.id.action_cancel) {
            // Handle cancel action
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}
