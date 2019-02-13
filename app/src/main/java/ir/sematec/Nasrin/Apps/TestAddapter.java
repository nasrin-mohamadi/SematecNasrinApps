package ir.sematec.Nasrin.Apps;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class TestAddapter extends RecyclerView.Adapter <TestAddapter.TestViewHolder>{


    @NonNull
    @Override
    public TestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

      View v =  LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_recycle_view,parent,false);
      TestViewHolder holder = new TestViewHolder(v);
      return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull TestViewHolder holder, int position) {

        switch (position){
            case 0:
                holder.txt.setText("pouya heydari");
                break;
            case 1:
                holder.txt.setText("salehi");
                break;
            case 2:
                holder.txt.setText("mohamadi");
                break;
            case 3:
                holder.txt.setText("lotfi");
                break;
            case 4:
                holder.txt.setText("tarighi");
                break;
            case 5:
                holder.txt.setText("alipour");
                break;
        }
    }

    @Override
    public int getItemCount() {
        return 11;
    }

    class TestViewHolder extends RecyclerView.ViewHolder{
        TextView txt;

        public TestViewHolder(@NonNull View itemView) {
            super(itemView);

            txt = itemView.findViewById(R.id.txtUserName);
        }


    }
}
