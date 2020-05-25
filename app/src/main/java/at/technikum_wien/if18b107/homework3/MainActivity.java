package at.technikum_wien.if18b107.homework3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.my_button);
        final EditText inName = (EditText) findViewById(R.id.my_name);
        final EditText inNumber = (EditText) findViewById(R.id.my_number);

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        String[] data = {"1","3$§,","esel"};
        mAdapter = new MyAdapter(data);
        recyclerView.setAdapter(mAdapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = inName.getText().toString();
                String number = inNumber.getText().toString();
                if(name.isEmpty() || number.isEmpty())
                {
                    Toast.makeText(MainActivity.this,"Eingabe fehlt...",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
