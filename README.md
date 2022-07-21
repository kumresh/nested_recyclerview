
# Nested RecyclerView

A RecyclerView can be used inside another RecyclerView. This is known as a nested RecyclerView. In this case, one RecyclerView widget is another RecyclerView widget's parent.



## Screenshots

| [![Screend Shoot](https://d1ow200m9i3wyh.cloudfront.net/img/assets/videoblocks/images/logo.png)](http://videoblocks.com)  
| [![Screen Shoot](https://dtyn3c8zjrx01.cloudfront.net/img/assets/audioblocks/images/logo.png)](http://audioblocks.com) |
|:---:|:---:|

## Pre Requiremnt

 - [RecyclerView](https://developer.android.com/guide/topics/ui/layout/recyclerview)
 - [Glide](https://github.com/bumptech/glide)

### Parent Layout

Designing for parent layout 

```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    xmlns:tools="http://schemas.android.com/tools"
    android:orientation="vertical"
    android:layout_marginHorizontal="10dp">


    <TextView
        android:id="@+id/parent_title"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Parent"
        android:textSize="18sp"
        android:textColor="@color/black"
        android:textStyle="bold"
        android:layout_marginBottom="8dp"/>

    <androidx.recyclerview.widget.RecyclerView
        android:id="@+id/child_recyclerview"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:listitem="@layout/child_item"/>

</LinearLayout>

```


### Creating Parent Adapter

creating custom Vewholder class inside adapter class

```
    class ParentHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val title:TextView
        val mRecyclerView:RecyclerView
        init {
            title = itemView.findViewById(R.id.parent_title)
            mRecyclerView = itemView.findViewById(R.id.child_recyclerview)
        }
    }
```

set layout from parent ViewGroup using LayoutInflater

```
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParentHolder {
        val mView = LayoutInflater.from(parent.context).inflate(R.layout.parent_item, parent, false)
        return ParentHolder(mView)
    }
```

implementing child Adapter in onBindViewHolder() method

```
    override fun onBindViewHolder(holder: ParentHolder, position: Int) {
        holder.title.text = parentList[position].title

    //        passing all movies list to the childadapter class
        childAdapter = ChildAdapter(parentList[position].movieList)
    //        set layout to horizontal
        holder.mRecyclerView.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        holder.mRecyclerView.adapter = childAdapter
    }
```


### Child Layout

```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_margin="4dp"
    android:orientation="vertical">

    <androidx.cardview.widget.CardView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:cardCornerRadius="8dp">
        <ImageView
            android:id="@+id/child_img"
            android:layout_width="150dp"
            android:layout_height="200dp"
            android:src="@drawable/test"/>
    </androidx.cardview.widget.CardView>
    <TextView
        android:id="@+id/child_title"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:gravity="center"
        android:lines="1"
        android:textColor="#123"
        android:text="movies"/>

</LinearLayout>
```

### MainActivity

creating lists and assigning datas.

```
    val mParentList = ArrayList<Parent>()

    val oscarWiningList = ArrayList<Movie>()
    val favoriteList = ArrayList<Movie>()
    val actionList = ArrayList<Movie>()
    val horrorList = ArrayList<Movie>()
    val comedyList = ArrayList<Movie>()

    mParentList.add(Parent("Oscar-Winning",oscarWiningList))
    mParentList.add(Parent("Favorite",favoriteList))
    mParentList.add(Parent("Action",actionList))
    mParentList.add(Parent("Horror",horrorList))
```

set Adapter

```
    mAdapter = ParentAdapter(this,mParentList)
    mRecyclerView.layoutManager = LinearLayoutManager(this)
    mRecyclerView.adapter = mAdapter

```


## Lessons Learned

By using Nested Recyclerview you may create a complex ui like. Netplex ui, Play store etc.


## Feedback

If you have any feedback, please reach out to us at kumresh030996@gmail.com

