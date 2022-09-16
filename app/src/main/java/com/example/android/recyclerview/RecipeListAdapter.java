
package com.example.android.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;;
import java.util.ArrayList;

public class RecipeListAdapter extends RecyclerView.Adapter<RecipeListAdapter.RecipeViewHolder>{
    private ArrayList<RecipeData> recipeList;
    private LayoutInflater mInflater;
    private View.OnClickListener mOnItemClickListener;

    public RecipeListAdapter(Context context, ArrayList<RecipeData> recipeList){
        this.mInflater = LayoutInflater.from(context);
        this.recipeList = recipeList;
    }

    //inflate the layout
    @NonNull
    @Override
    public RecipeListAdapter.RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View mItemView = mInflater.inflate(R.layout.item_list, viewGroup, false);
        return new RecipeViewHolder(mItemView);
    }


    //on bind process -assigning values to the recyclerview based on position
    @Override
    public void onBindViewHolder(@NonNull RecipeListAdapter.RecipeViewHolder recipeViewHolder, int position) {
        recipeViewHolder.name.setText((recipeList.get(position)).getName());
        recipeViewHolder.description.setText((recipeList.get(position)).getDescription());
        recipeViewHolder.image.setImageResource(recipeList.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }


    public void setOnItemClickListener(View.OnClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    //inner class to grabbing views from item_list layout and assign them values
    public  class RecipeViewHolder extends RecyclerView.ViewHolder {
        TextView name, description;
        ImageView image;


        public RecipeViewHolder(View itemView){
            super(itemView);

            name = itemView.findViewById(R.id.recipe_name);
            description = itemView.findViewById(R.id.recipe_description);
            image = itemView.findViewById(R.id.recipe_image);

            itemView.setTag(this); //use the same onClick for every button

            itemView.setOnClickListener(mOnItemClickListener);
        }
    }
}