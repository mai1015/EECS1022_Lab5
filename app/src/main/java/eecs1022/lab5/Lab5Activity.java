package eecs1022.lab5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Lab5Activity extends AppCompatActivity
{

    private Bank b;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab5);

        b = new Bank();
    }

    private void setTextViewById(int ID, String text) {
        TextView view = (TextView) findViewById(ID);
        view.setText(text);
    }

    private String getInputById(int ID) {
        EditText view = (EditText) findViewById(ID);
        return view.getText().toString();
    }

    private String getItemSelectedById(int ID) {
        Spinner spinner = (Spinner) findViewById(ID);
        return spinner.getSelectedItem().toString();
    }

    public void onCreateClient(View view) {
        String name = getInputById(R.id.inputNewName);
        float bal = Float.parseFloat(getInputById(R.id.inputNewBalance));
        Client c = new Client(name, bal);
        try {
            b.addClient(c);
            setTextViewById(R.id.lableResult, "Updated Balances of Clients:\n" + b.toString());
        }catch (Error e) {
            setTextViewById(R.id.lableResult, "Error:" + e.getMessage());
        }
    }

    public void onAction(View view) {
        String act = getItemSelectedById(R.id.spinnerService);
        String from = getInputById(R.id.inputFrom);
        String to = getInputById(R.id.inputTo);
        float amount = Float.parseFloat(getInputById(R.id.inputAmount));

        try {
            b.doAction(act, from, to, amount);
            setTextViewById(R.id.lableResult, "Updated Balances of Clients:\n" + b.toString());
        } catch (Error e) {
            setTextViewById(R.id.lableResult, "Error:" + e.getMessage());
        }
    }

    public void onCheckTransacion(View view) {
        String name = getInputById(R.id.inputName);

        Client c = b.getClient(name);
        if (c == null)
            setTextViewById(R.id.lableResult, String.format("Error: Client %s does not exist.", name));
        else
            setTextViewById(R.id.lableResult, String.format("Statement of client %s (current balance $%.2f):\n%s", name, c.getAmount(), c.printHistory()));
    }
}
