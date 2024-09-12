package com.maggiver.appetizers

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.maggiver.appetizers.ui.theme.AppetizersTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppetizersTheme {

                val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
                val scope = rememberCoroutineScope()


                ModalNavigationDrawer(
                    drawerContent = {
                        ModalDrawerSheet {
                            Text(
                                "Menu Appetizers",
                                modifier = Modifier.padding(16.dp),
                                fontSize = 22.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Divider()
                            NavigationDrawerItem(
                                label = { Text(text = "Restaurantes") },
                                selected = false,
                                onClick = { /*TODO*/ }
                            )

                            Divider()
                            NavigationDrawerItem(
                                label = { Text(text = "Platos") },
                                selected = false,
                                onClick = { /*TODO*/ }
                            )

                            Divider()
                            NavigationDrawerItem(
                                label = { Text(text = "Ensaladas") },
                                selected = false,
                                onClick = { /*TODO*/ }
                            )

                            Divider()
                            NavigationDrawerItem(
                                label = { Text(text = "Bebidas") },
                                selected = false,
                                onClick = { /*TODO*/ }
                            )

                            Divider()
                            NavigationDrawerItem(
                                label = { Text(text = "Cerrar Sesión", fontWeight = FontWeight.Bold) },
                                selected = false,
                                onClick = { /*TODO*/ },
                                icon = {
                                    Icon(imageVector = Icons.Outlined.Lock, contentDescription = "Icon Log Up")
                                }
                            )
                        }

                    },
                    modifier = Modifier,
                    drawerState = drawerState
                ) {

                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        topBar = {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(Color(0xFFFFFCFC)),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically,
                            ) {

                                IconButton(onClick = {
                                    scope.launch {
                                        drawerState.apply {
                                            if (isClosed) {
                                                open()
                                            } else {
                                                close()
                                            }
                                        }
                                    }
                                }) {
                                    Image(
                                        imageVector = Icons.Outlined.Menu,
                                        contentDescription = "icon menu"
                                    )
                                }

                                Text(
                                    text = resources.getString(R.string.app_name),
                                    fontSize = 22.sp,
                                    fontWeight = FontWeight.Bold
                                )

                                IconButton(onClick = { /*TODO*/ }) {
                                    Image(
                                        imageVector = Icons.Outlined.ShoppingCart,
                                        contentDescription = "icon cart",
                                        modifier = Modifier.size(24.dp)
                                    )
                                }

                            }
                        }
                    ) { paddingValues ->

                        MainComponent(paddingValues)
                    }
                }

            }
        }
    }


}

@Composable
private fun MainComponent(paddingValues: PaddingValues) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF495E57))
            .padding(top = 72.dp, start = 16.dp, end = 16.dp, bottom = 16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "Tacacho Majao",
            modifier = Modifier,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFF4CE14)
        )
        Text(
            text = "Restaurant Amazonico",
            modifier = Modifier,
            fontSize = 22.sp,
            color = Color(0xFFFFFFFF)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top
        ) {
            Text(
                text = stringResource(id = R.string.description),
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .padding(end = 12.dp)
                    .background(Color.Unspecified),
                fontSize = 18.sp,
                color = Color(0xFFFFFFFF)
            )

            Image(
                painter = painterResource(id = R.drawable.chef2),
                contentDescription = "chef image",
                modifier = Modifier
                    .width(130.dp)
                    .clip(RoundedCornerShape(16.dp))
            )
        }

        Button(
            onClick = { },
            modifier = Modifier.padding(top = 8.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF4CE14)),
        ) {
            Text(
                text = stringResource(id = R.string.order_take_away),
                modifier = Modifier,
                color = Color(0xFF413510),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun ModalDrawerSheet(name: PaddingValues) {

}

