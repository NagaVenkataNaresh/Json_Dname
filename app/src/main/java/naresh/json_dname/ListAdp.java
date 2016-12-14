package naresh.json_dname;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.zip.Inflater;

/**
 * Created by Naresh on 14-12-2016.
 */

public class ListAdp extends BaseAdapter
{

    Context con;
    public ListAdp(Context c)
    {
        c=con;
    }

    @Override
    public int getCount()
    {
        return 0;
    }

    @Override
    public Object getItem(int i)
    {
        return null;
    }

    @Override
    public long getItemId(int i)
    {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        LayoutInflater li = (LayoutInflater)con.getSystemService(con.LAYOUT_INFLATER_SERVICE);
        View v = li.inflate(R.layout.sample,viewGroup,false);



        return null;
    }
}
