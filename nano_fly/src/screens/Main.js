import React, { Component } from "react";
import { StyleSheet, Text, View, TextInput, Image, TouchableHighlight} from 'react-native';
 
export default class Main extends Component{
  constructor(props) {
    super(props);
    this.cambioPagina=this.cambioPagina.bind(this);
    this.state={
      origin:"",
      destine:""
    }
  }
  
  componentDidMount = async () => {
  };


  cambioPagina(){
    this.props.navigation.navigate('Flight',{
      origin: this.state.origin,
      destine: this.state.destine
    });
  }

  render(){
    return (
      <View style={styles.container}>
      <Image style={styles.imageIcon} 
        source={require('nano_fly/assets/icon.png')}/>
      <Text style={styles.text}>Ciudad de origen</Text>
      <TextInput style = {styles.input}
        underlineColorAndroid = "transparent"
        placeholder = "ORIGEN"
        placeholderTextColor = "white"
        autoCapitalize = "none"
        textContentType="password"
        alignItems="center"
        onChangeText={(text) => this.setState({ origin: text })}
      />
      <Text style={styles.text}>Ciudad de destino</Text>
      <TextInput style = {styles.input}
        underlineColorAndroid = "transparent"
        placeholder = "DESTINO"
        placeholderTextColor = "white"
        autoCapitalize = "none"
        onChangeText={(text) => this.setState({ destine: text })}
      />
      <TouchableHighlight onPress={this.cambioPagina}>
        <View style={styles.button}>
          <Text style={styles.textButton}>Buscar...<Text>    </Text>
        <Image style={styles.imageButton} 
          source={require('nano_fly/assets/search.png')}/>
          </Text>
        </View>
      </TouchableHighlight> 
    </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: 'rgba(190,21,190, 0.5)',
    paddingTop:"15%",
  },
  imageIcon:{
    alignSelf: "center",
  },
  text:{
    color: "black",
    fontSize: 20,
    lineHeight: 45,
    fontWeight: "bold",
    textAlign: "center",
    backgroundColor: "#E0E0E0",
    marginTop:35
  },
  input: {
    margin: "5%",
    height: 40,
    borderColor: '#000',
    borderWidth: 3,
    backgroundColor:'green',
    color:"white",
    borderRadius:20,
    paddingLeft:15,
    textAlign:"center"
  },
  button:{
    alignItems:"center",
    backgroundColor:"blue",
    borderRadius:20,
    borderWidth:3,
    textAlign:"center",
    height:40,
    marginHorizontal:60,
  },
  textButton:{
    fontSize:28,
    color:"white"
  },
  imageButton:{
    width:27,
    height:30
  }
});
