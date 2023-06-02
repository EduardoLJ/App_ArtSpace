package com.eddlj.app_artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eddlj.app_artspace.ui.theme.App_ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App_ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpace_App()
                }
            }
        }
    }
}

@Composable
fun ArtSpace_App(modifier: Modifier = Modifier
    .fillMaxSize()
    .wrapContentSize(Alignment.Center)) {
    var previous by remember{ mutableStateOf(1) }
    Surface() {
        Column(modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = ArtImageClick(result = previous)),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize(0.75f)
            )
            Text(
                text = stringResource(id = ArtNameClick(result = previous)),
                fontWeight = FontWeight.Light,
                fontSize = 25.sp
            )
            Text(
                text = stringResource(id = ArtDateClick(result = previous)),
                fontWeight = FontWeight.Bold

            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
            ) {
                Button(
                    onClick = { /*TODO*/
                        if (previous>1){
                            previous--
                        }else{
                            previous=1
                        }
                    },
                    modifier = Modifier.padding(16.dp)) {
                    Text(text = "Previous")
                }

                Button(
                    onClick = { /*TODO*/
                        if (previous<8){
                            previous++
                        }else{
                            previous=7
                        }
                    },
                    modifier = Modifier.padding(16.dp))
                {
                    Text(text = "Next")
                }
            }
        }
    }
}

@Composable
fun ArtImageClick(result: Int):Int{
    val imageResource = when(result){
        1->com.eddlj.app_artspace.R.drawable.prettyinpink_1_angiewright
        2->com.eddlj.app_artspace.R.drawable.sungazer_angiewright
        3->com.eddlj.app_artspace.R.drawable.rainsymphony_ekatherinaermilkina
        4->com.eddlj.app_artspace.R.drawable.citystreetscene_ekatherinaermilkina
        5->com.eddlj.app_artspace.R.drawable.cayenne_mariamoretti
        6->com.eddlj.app_artspace.R.drawable.geometricimpresion_mariamoretti
        7->com.eddlj.app_artspace.R.drawable.summerrhapsodyxl1_peternottrott
        8->com.eddlj.app_artspace.R.drawable.glorydayxl6_peternottrott
        9->com.eddlj.app_artspace.R.drawable.magicpanther_vicentbardou
        else->com.eddlj.app_artspace.R.drawable.medusa_vicentbardou
    }
    return imageResource
}
@Composable
fun ArtNameClick(result: Int):Int{
    val nameStringResource = when(result){
        1->com.eddlj.app_artspace.R.string.wright_pip
        2->com.eddlj.app_artspace.R.string.wright_sg
        3->com.eddlj.app_artspace.R.string.ermilkina_rs
        4->com.eddlj.app_artspace.R.string.ermilkina_css
        5->com.eddlj.app_artspace.R.string.moretti_c
        6->com.eddlj.app_artspace.R.string.moretti_gi
        7->com.eddlj.app_artspace.R.string.nottrott_sr
        8->com.eddlj.app_artspace.R.string.nottrott_gd
        9->com.eddlj.app_artspace.R.string.bardou_mp
        else->com.eddlj.app_artspace.R.string.bardou_m
    }
    return nameStringResource
}
@Composable
fun ArtDateClick(result: Int):Int{
    val dateStringResource = when(result){
        1->com.eddlj.app_artspace.R.string.wright_pip_date
        2->com.eddlj.app_artspace.R.string.wright_sg_date
        3->com.eddlj.app_artspace.R.string.ermilkina_rs_date
        4->com.eddlj.app_artspace.R.string.ermilkina_css_date
        5->com.eddlj.app_artspace.R.string.moretti_c_date
        6->com.eddlj.app_artspace.R.string.moretti_gi_date
        7->com.eddlj.app_artspace.R.string.nottrott_sr_date
        8->com.eddlj.app_artspace.R.string.nottrott_gd_date
        9->com.eddlj.app_artspace.R.string.bardou_mp_date
        else-> com.eddlj.app_artspace.R.string.bardou_m_date
    }
    return dateStringResource
}