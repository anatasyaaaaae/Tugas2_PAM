package edu.uksw.fti.pam.pam_activity_intent

import android.annotation.SuppressLint
import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class CobaActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyBottomNavigation()
            HaloForm()
            AtasForm()
            BestSellerSection()
        }
    }
}


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MyBottomNavigation() {
    var bottomState by remember {
        mutableStateOf("")
    }
    Scaffold(
        content = {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                Alignment.Center) {
                Text(text = bottomState,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                )
            }
        },
        bottomBar = {
            BottomNavigation(
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)),
                backgroundColor = Color.White,
                contentColor = Color.Gray
            ) {
                BottomNavigationItem(
                    selected = bottomState == "Home" ,
                    onClick = { bottomState = "Home"},
                    label = { Text(text = "Home")},
                    icon = { Icon(imageVector = Icons.Default.Home, contentDescription = null)}
                )

                BottomNavigationItem(
                    selected = bottomState == "Promo" ,
                    onClick = { bottomState = "Promo"},
                    label = { Text(text = "Promo")},
                    icon = { Icon(imageVector = Icons.Default.Favorite, contentDescription = null)}
                )
                BottomNavigationItem(
                    selected = bottomState == "Pesanan" ,
                    onClick = { bottomState = "Pesanan"},
                    label = { Text(text = "Pesanan")},
                    icon = { Icon(imageVector = Icons.Default.List, contentDescription = null)}
                )
                BottomNavigationItem(
                    selected = bottomState == "Chat" ,
                    onClick = { bottomState = "Chat"},
                    label = { Text(text = "Chat")},
                    icon = { Icon(imageVector = Icons.Default.Email, contentDescription = null)}
                )

            }
        }
    )
}

@Composable
fun HaloForm(){
    val lContext = LocalContext.current
    var cariInput by remember { mutableStateOf("") }
    var iklanInput by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(1.dp),
        verticalArrangement = Arrangement.spacedBy(530.dp)
    ) {
        TextField(
            value = cariInput,
            onValueChange = { cariInput = it },
            label = { Text(text = "")},
            modifier = Modifier
                .background(Color.Green)
                .size(width = 600.dp, height = 90.dp,),
            trailingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Filled.AccountCircle,
                        contentDescription = "Acoount Icons",
                                modifier = Modifier
                                .size(60.dp),
                    )

                }
            }

        )
        TextField(
            value = iklanInput,
            onValueChange = { iklanInput = it },
            label = { Text(text = "")},
            modifier = Modifier.size(width = 500.dp, height = 150.dp,),
                    trailingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Image(
                        painterResource(id = R.drawable.iklan),
                        contentDescription = "Acoount Icons",
                        modifier = Modifier
                            .size(850.dp,)
                    )

                }
            }
        )
    }
}



@Composable
fun AtasForm() {
    val lContext = LocalContext.current
    var atasInput by remember { mutableStateOf("") }
    var bawahInput by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
        verticalArrangement = Arrangement.spacedBy(550.dp)
    ) {
        TextField(
            value = atasInput,
            onValueChange = { atasInput = it },
            label = { Text(text = "Cari layanan, makanan, & tujuan")},
            modifier = Modifier
                .background(Color.White),
           leadingIcon = {
               Icon(imageVector = Icons.Filled.Search,
                   contentDescription = "Search Icon")

            }

        )
    }
}


@Composable
fun BestSellerSection() {
    Column() {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Akses Cepat", Modifier.padding(top = 502.dp), style = MaterialTheme.typography.h6)
            TextButton(onClick = {}) {
            }
        }
    }
}

@Composable
fun Vocher() {
    val lContext = LocalContext.current
    var usernameInput by remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 100.dp)
            .padding(horizontal = 15.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        TextField(
            value = usernameInput,
            onValueChange = { usernameInput = it },
            label = { Text(text = "Gopay") },
            modifier = Modifier
                .size(width = 600.dp, height = 90.dp,),
            trailingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Image(
                        painterResource(id = R.drawable.icon),
                        contentDescription = "Acoount Icons",
                        modifier = Modifier
                            .padding(top = 15.dp)
                            .size(10.dp,)
                    )

                }
    })
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyBottomNavigation()
    HaloForm()
    AtasForm()
    BestSellerSection()
    Vocher()
}