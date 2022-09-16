
package com.example.android.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<RecipeData> recipeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        prepareRecipeList();

        RecipeListAdapter recipeListAdapter = new RecipeListAdapter(MainActivity.this, recipeList);
        recyclerView.setAdapter(recipeListAdapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

//        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recipeListAdapter.setOnItemClickListener(onItemClickListener);
    }

    private void prepareRecipeList() {
        recipeList = new ArrayList<>();
        RecipeData data;
        data = new RecipeData("Easy pancakes", "Super easy pancakes with only 4 ingredients", R.drawable.pan,getString(R.string.pancakeDes));
        recipeList.add(data);
        data = new RecipeData("Chocolate praline pancake cake", "If you like a sweet chocolate filling for your pancake you'll love this indulgent fondant cake with deep, rich sauce", R.drawable.cake,getString(R.string.cake));
        recipeList.add(data);
        data = new RecipeData("Easy chocolate fudge cake", "Need a guaranteed crowd-pleasing cake that's easy to make? This super-squidgy chocolate fudge cake with smooth icing is an instant baking win", R.drawable.fcake,getString(R.string.fcake));
        recipeList.add(data);
        data = new RecipeData("Slow-cooked porridge", "Need a guaranteed crowd-pleasing cake that's easy to make? This super-squidgy chocolate fudge cake with smooth icing is an instant baking win", R.drawable.porridge,getString(R.string.porridge));
        recipeList.add(data);
        data = new RecipeData("Raspberry & almond traybake", "One mixture all whizzed in the food processor makes the base and topping for this bake" , R.drawable.raspberry,getString(R.string.Raspberry));
        recipeList.add(data);
        data = new RecipeData("Fastest ever lemon pudding", "Being short of time needn't stop you making your own pudding. This microwave-friendly sponge is ready in 10 minutes and can easily be a chocolate pud too" , R.drawable.lemob,getString(R.string.lemon));
        recipeList.add(data);
        data = new RecipeData("Mini summer puddings", "The crowning glory of English puddings, Gordon Ramsay combines summer fruits to perfection. Step-by-step guide" , R.drawable.puddings,getString(R.string.puddings));
        recipeList.add(data);

    }

    //Opens the Detail Activity and crates the Bundle data to be displayed
    public void openDetailActivity(int imageId, String details){
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        intent.putExtra("image", imageId);
        intent.putExtra("details", details);
        startActivity(intent);
    }

    private View.OnClickListener onItemClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) v.getTag();
            int position = viewHolder.getAdapterPosition();
            RecipeData thisRecipe = recipeList.get(position);
            openDetailActivity(thisRecipe.getImage(), thisRecipe.getDetails());

        }
    };
}