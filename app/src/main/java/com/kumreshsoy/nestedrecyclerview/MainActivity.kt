package com.kumreshsoy.nestedrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mAdapter: ParentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mRecyclerView = findViewById(R.id.parent_recyclerview)
        setAdapter()
    }

    private fun setAdapter(){

        val mParentList = ArrayList<Parent>()

        val oscarWiningList = ArrayList<Movie>()
        val favoriteList = ArrayList<Movie>()
        val actionList = ArrayList<Movie>()
        val horrorList = ArrayList<Movie>()
        val comedyList = ArrayList<Movie>()

//        initialising all list

        oscarWiningList.add(Movie("Top Gun","https://m.media-amazon.com/images/M/MV5BZjQxYTA3ODItNzgxMy00N2Y2LWJlZGMtMTRlM2JkZjI1ZDhhXkEyXkFqcGdeQXVyNDk3NzU2MTQ@._V1_UX67_CR0,0,67,98_AL_.jpg"))
        oscarWiningList.add(Movie("The Godfather","https://m.media-amazon.com/images/M/MV5BM2MyNjYxNmUtYTAwNi00MTYxLWJmNWYtYzZlODY3ZTk3OTFlXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_UY98_CR1,0,67,98_AL_.jpg"))
        oscarWiningList.add(Movie("Once Upon a Time in... Hollywood","https://m.media-amazon.com/images/M/MV5BOTg4ZTNkZmUtMzNlZi00YmFjLTk1MmUtNWQwNTM0YjcyNTNkXkEyXkFqcGdeQXVyNjg2NjQwMDQ@._V1_UX67_CR0,0,67,98_AL_.jpg"))
        oscarWiningList.add(Movie("No Time to Die","https://m.media-amazon.com/images/M/MV5BYWQ2NzQ1NjktMzNkNS00MGY1LTgwMmMtYTllYTI5YzNmMmE0XkEyXkFqcGdeQXVyMjM4NTM5NDY@._V1_UX67_CR0,0,67,98_AL_.jpg"))
        oscarWiningList.add(Movie("Goodfellas","https://m.media-amazon.com/images/M/MV5BY2NkZjEzMDgtN2RjYy00YzM1LWI4ZmQtMjIwYjFjNmI3ZGEwXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_UX67_CR0,0,67,98_AL_.jpg"))
        oscarWiningList.add(Movie("Jurassic Park","https://m.media-amazon.com/images/M/MV5BMjM2MDgxMDg0Nl5BMl5BanBnXkFtZTgwNTM2OTM5NDE@._V1_UX67_CR0,0,67,98_AL_.jpg"))
        oscarWiningList.add(Movie("Dune: Part One","https://m.media-amazon.com/images/M/MV5BN2FjNmEyNWMtYzM0ZS00NjIyLTg5YzYtYThlMGVjNzE1OGViXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_UX67_CR0,0,67,98_AL_.jpg"))
        oscarWiningList.add(Movie("The Dark Knight","https://m.media-amazon.com/images/M/MV5BMTMxNTMwODM0NF5BMl5BanBnXkFtZTcwODAyMTk2Mw@@._V1_UX67_CR0,0,67,98_AL_.jpg"))
        oscarWiningList.add(Movie("Titanic","https://m.media-amazon.com/images/M/MV5BMDdmZGU3NDQtY2E5My00ZTliLWIzOTUtMTY4ZGI1YjdiNjk3XkEyXkFqcGdeQXVyNTA4NzY1MzY@._V1_UX67_CR0,0,67,98_AL_.jpg"))
        mParentList.add(Parent("Oscar-Winning",oscarWiningList))

        favoriteList.add(Movie("Samaritan","https://m.media-amazon.com/images/M/MV5BY2M2MjMxNjUtZWU2MS00NTIwLWE0ZDEtOTY3NzY5NGZmY2RmXkEyXkFqcGdeQXVyODk2NDQ3MTA@._V1_UX67_CR0,0,67,98_AL_.jpg"))
        favoriteList.add(Movie("Ghostbusters","https://m.media-amazon.com/images/M/MV5BMTkxMjYyNzgwMl5BMl5BanBnXkFtZTgwMTE3MjYyMTE@._V1_UX67_CR0,0,67,98_AL_.jpg"))
        favoriteList.add(Movie("Mortal Engines","https://m.media-amazon.com/images/M/MV5BNzY1MDA2OTQ0N15BMl5BanBnXkFtZTgwMTkzNjU2NTM@._V1_UX67_CR0,0,67,98_AL_.jpg"))
        favoriteList.add(Movie("Teenage Mutant Ninja Turtles","https://m.media-amazon.com/images/M/MV5BNTM5OTMwNGUtZjAzMC00MmExLTg0MDYtMjRlN2U2OGI1YzhiXkEyXkFqcGdeQXVyODUwNjEzMzg@._V1_UX67_CR0,0,67,98_AL_.jpg"))
        favoriteList.add(Movie("Hellboy II: The Golden Army","https://m.media-amazon.com/images/M/MV5BMjA5NzgyMjc2Nl5BMl5BanBnXkFtZTcwOTU3MDI3MQ@@._V1_UX67_CR0,0,67,98_AL_.jpg"))
        favoriteList.add(Movie("R.I.P.D.","https://m.media-amazon.com/images/M/MV5BMTM5OTYxNzE5N15BMl5BanBnXkFtZTcwMDU1MTQ4OQ@@._V1_UX67_CR0,0,67,98_AL_.jpg"))
        favoriteList.add(Movie("Mystery Men","https://m.media-amazon.com/images/M/MV5BYjZhZmY4NDctNWU5Mi00MGI0LTkzMGUtMjRiZWM2MTdiNjBkXkEyXkFqcGdeQXVyMjUzOTY1NTc@._V1_UX67_CR0,0,67,98_AL_.jpg"))
        favoriteList.add(Movie("Trollhunters","https://m.media-amazon.com/images/M/MV5BN2Y2YWE0ZDMtNzQzMC00MDI0LThlZjAtMWY4YjZlYWM2OWFjXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_UX67_CR0,0,67,98_AL_.jpg"))
        mParentList.add(Parent("Favorite",favoriteList))

        actionList.add(Movie("Thor: Love and Thunder","https://m.media-amazon.com/images/M/MV5BYmMxZWRiMTgtZjM0Ny00NDQxLWIxYWQtZDdlNDNkOTEzYTdlXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_UX67_CR0,0,67,98_AL_.jpg"))
        actionList.add(Movie("Ms. Marvel","https://m.media-amazon.com/images/M/MV5BZmQ3OTZkNDUtNTU0Mi00ZjE4LTgyNTUtY2E4NWRmNDUxMzkyXkEyXkFqcGdeQXVyMDM2NDM2MQ@@._V1_UX67_CR0,0,67,98_AL_.jpg"))
        actionList.add(Movie("Doctor Strange in the Multiverse of Madness","https://m.media-amazon.com/images/M/MV5BNWM0ZGJlMzMtZmYwMi00NzI3LTgzMzMtNjMzNjliNDRmZmFlXkEyXkFqcGdeQXVyMTM1MTE1NDMx._V1_UX67_CR0,0,67,98_AL_.jpg"))
        actionList.add(Movie("Thor: Ragnarok","https://m.media-amazon.com/images/M/MV5BMjMyNDkzMzI1OF5BMl5BanBnXkFtZTgwODcxODg5MjI@._V1_UX67_CR0,0,67,98_AL_.jpg"))
        actionList.add(Movie("Spider-Man: No Way Home","https://m.media-amazon.com/images/M/MV5BZWMyYzFjYTYtNTRjYi00OGExLWE2YzgtOGRmYjAxZTU3NzBiXkEyXkFqcGdeQXVyMzQ0MzA0NTM@._V1_UX67_CR0,0,67,98_AL_.jpg"))
        actionList.add(Movie("Thor","https://m.media-amazon.com/images/M/MV5BOGE4NzU1YTAtNzA3Mi00ZTA2LTg2YmYtMDJmMThiMjlkYjg2XkEyXkFqcGdeQXVyNTgzMDMzMTg@._V1_UX67_CR0,0,67,98_AL_.jpg"))
        actionList.add(Movie("Moon Knight","https://m.media-amazon.com/images/M/MV5BYTc5OWNhYjktMThlOS00ODUxLTgwNDQtZjdjYjkyM2IwZTZlXkEyXkFqcGdeQXVyNTA3MTU2MjE@._V1_UX67_CR0,0,67,98_AL_.jpg"))
        actionList.add(Movie("The Marvels","https://m.media-amazon.com/images/M/MV5BNjQ4NzQ2MmUtMTUwYi00ZTVhLWI5Y2MtYWM3ZmM5MTc1OGEyXkEyXkFqcGdeQXVyODk4OTc3MTY@._V1_UX67_CR0,0,67,98_AL_.jpg"))
        actionList.add(Movie("Avengers: Endgame","https://m.media-amazon.com/images/M/MV5BMTc5MDE2ODcwNV5BMl5BanBnXkFtZTgwMzI2NzQ2NzM@._V1_UX67_CR0,0,67,98_AL_.jpg"))
        mParentList.add(Parent("Action",actionList))

        horrorList.add(Movie("Stranger Things","https://m.media-amazon.com/images/M/MV5BMDZkYmVhNjMtNWU4MC00MDQxLWE3MjYtZGMzZWI1ZjhlOWJmXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_UY98_CR5,0,67,98_AL_.jpg"))
        horrorList.add(Movie("Resident Evil","https://m.media-amazon.com/images/M/MV5BMmVhNzY5YjItMTBlNC00N2ZmLWE5ZGYtMTUzMDA0YjEwOGY0XkEyXkFqcGdeQXVyMTEzMTI1Mjk3._V1_UX67_CR0,0,67,98_AL_.jpg"))
        horrorList.add(Movie("The Black Phone","https://m.media-amazon.com/images/M/MV5BOWVmNTBiYTUtZWQ3Yi00ZDlhLTgyYjUtNzBhZjM3YjRiNGRkXkEyXkFqcGdeQXVyNzYyOTM1ODI@._V1_UX67_CR0,0,67,98_AL_.jpg"))
        horrorList.add(Movie("Doctor Strange in the Multiverse of Madness","https://m.media-amazon.com/images/M/MV5BNWM0ZGJlMzMtZmYwMi00NzI3LTgzMzMtNjMzNjliNDRmZmFlXkEyXkFqcGdeQXVyMTM1MTE1NDMx._V1_UX67_CR0,0,67,98_AL_.jpg"))
        horrorList.add(Movie("Incantation","https://m.media-amazon.com/images/M/MV5BYjUxZGI1ODQtMDljMS00ZTUwLWI0NTMtYjc2YmUyZTM3YTdhXkEyXkFqcGdeQXVyNTM2NTY4NzU@._V1_UY98_CR0,0,67,98_AL_.jpg"))
        horrorList.add(Movie("The Walking Dead","https://m.media-amazon.com/images/M/MV5BZmU5NTcwNjktODIwMi00ZmZkLTk4ZWUtYzVjZWQ5ZTZjN2RlXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_UX67_CR0,0,67,98_AL_.jpg"))
        horrorList.add(Movie("What We Do in the Shadows","https://m.media-amazon.com/images/M/MV5BNWYwNGMwNTItMzZiNS00YTNhLTg5ZDItOTE5YzdhYWRjOWQ2XkEyXkFqcGdeQXVyMTUzMTg2ODkz._V1_UY98_CR0,0,67,98_AL_.jpg"))
        horrorList.add(Movie("Supernatural","https://m.media-amazon.com/images/M/MV5BNzRmZWJhNjUtY2ZkYy00N2MyLWJmNTktOTAwY2VkODVmOGY3XkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_UX67_CR0,0,67,98_AL_.jpg"))
        horrorList.add(Movie("Winnie-The-Pooh: Blood and Honey","https://m.media-amazon.com/images/M/MV5BNTg2MDhhYzQtNDZjNi00MjRmLTg3NWYtMzg2ZGJkYmI2MmE0XkEyXkFqcGdeQXVyNjUxMDQ0MTg@._V1_UY98_CR2,0,67,98_AL_.jpg"))
        mParentList.add(Parent("Horror",horrorList))

        comedyList.add(Movie("What We Do in the Shadows","https://m.media-amazon.com/images/M/MV5BNWYwNGMwNTItMzZiNS00YTNhLTg5ZDItOTE5YzdhYWRjOWQ2XkEyXkFqcGdeQXVyMTUzMTg2ODkz._V1_UY98_CR0,0,67,98_AL_.jpg"))
        comedyList.add(Movie("Bodies Bodies Bodies","https://m.media-amazon.com/images/M/MV5BYTA2ODg5ZjgtOTU2My00MzFkLWI0NzMtZmQ5MmRhMWU1NzhlXkEyXkFqcGdeQXVyMTM1MTE1NDMx._V1_UX67_CR0,0,67,98_AL_.jpg"))
        comedyList.add(Movie("The Munsters","https://m.media-amazon.com/images/M/MV5BYmYyYWQ2ZmEtYTEzZi00OGExLWE0YTItOGYyODBhY2M4NDI1XkEyXkFqcGdeQXVyNTYzMTc4MzY@._V1_UY98_CR1,0,67,98_AL_.jpg"))
        comedyList.add(Movie("Love, Death & Robots","https://m.media-amazon.com/images/M/MV5BYTNiYTNkNTAtYzE3ZS00ZDQ1LWEwZTYtZjI1NzYzMWJjY2U4XkEyXkFqcGdeQXVyODk4OTc3MTY@._V1_UX67_CR0,0,67,98_AL_.jpg"))
        comedyList.add(Movie("Day Shift","https://m.media-amazon.com/images/M/MV5BYWI2ZDRjYjEtOWJiOS00NWVjLWI1MjAtNWNiMzAwNGFmNjljXkEyXkFqcGdeQXVyODEwMTc2ODQ@._V1_UX67_CR0,0,67,98_AL_.jpg"))
        comedyList.add(Movie("The Baby","https://m.media-amazon.com/images/M/MV5BOGJkNTQwZGYtMWVkYS00ODFiLWI3MjYtZGU2NTZiMWEyYzZjXkEyXkFqcGdeQXVyMTAyMjQ3NzQ1._V1_UX67_CR0,0,67,98_AL_.jpg"))
        comedyList.add(Movie("What We Do in the Shadows","https://m.media-amazon.com/images/M/MV5BYmYyYWY4NjgtNGQ2Yi00NDNiLWJlOTgtYjI1MTI0NjZkNjhhXkEyXkFqcGdeQXVyNDE5MTU2MDE@._V1_UY98_CR0,0,67,98_AL_.jpg"))
        comedyList.add(Movie("Fresh","https://m.media-amazon.com/images/M/MV5BZTgxMGQ2ZDctYWY4Yy00YTI4LWIxMmYtOWViMGI5ZDIwMmFiXkEyXkFqcGdeQXVyMTAyMjQ3NzQ1._V1_UX67_CR0,0,67,98_AL_.jpg"))
        comedyList.add(Movie("Hocus Pocus 2","https://m.media-amazon.com/images/M/MV5BMjA0ODA5NmEtMTY1Yy00MTJmLWExOGUtYjc5MWQ5NTEzMzFhXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_UX67_CR0,0,67,98_AL_.jpg"))
        mParentList.add(Parent("Comedy",comedyList))

        mAdapter = ParentAdapter(this,mParentList)
        mRecyclerView.layoutManager = LinearLayoutManager(this)
        mRecyclerView.adapter = mAdapter
    }

}