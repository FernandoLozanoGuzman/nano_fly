import React,{Component} from 'react'
import { StyleSheet, Text, View, SafeAreaView, FlatList, TouchableOpacity,Alert,Image} from 'react-native';
 
export default class TicketFlight extends Component{
  
  constructor(props){
    super(props);
    
    this.state={
      todo:props.route.params.flight
    }
  }
  
  componentDidMount = async () => {
  };

  booking(destine){
    Alert.alert(
      "Vuelo reservado",
      "Gracias por reservar el vuelo.\nDisfruta de las vacaiones en "+destine
      
    );
  }

  showAirline(airline){
    Alert.alert(
      "Detalles de la aerolinea",
      "Nombre: "+airline.name+"\nFlota actual de la compañia: "+airline.fleet+"\nWeb: "+airline.web
      
    );
  }

  showAirport(airport){
    Alert.alert(
      "Detalles del aeropuerto",
      "Nombre: "+airport.nameAirport+"\nCiudad: "+airport.city+"\nCódigo IATA: "+airport.codeIATA+"\nLocalización: "+airport.location
      
    );
  }

    render(){
      const todo=this.state;
      const flight=[todo]

      const Item = ({ aeropuertoSalida, fechaSalida, horaSalida, aeropuertoLlegada, fechaLlegada, horaLlegada, precio, airline, asiento }) => (
        <View>
          <View style={styles.flight}>
            <View>
              <Text style={styles.header}>Billete de vuelo</Text>
                <View style={{flex: 5, height:4, width:275, backgroundColor: 'black'}} />
                <Text></Text>
                <View style={styles.direction}>
                  <View style={styles.viewLocation}>
                    <TouchableOpacity onPress={() => {this.showAirport(aeropuertoSalida)}}>
                      <Text>{aeropuertoSalida.city}  -  {aeropuertoSalida.nameAirport} ({aeropuertoSalida.codeIATA})</Text>
                    </TouchableOpacity>
                    
                    <TouchableOpacity onPress={() => {this.showAirport(aeropuertoLlegada)}}>
                      <Text>{aeropuertoLlegada.city}  -  {aeropuertoLlegada.nameAirport} ({aeropuertoLlegada.codeIATA})</Text>
                    </TouchableOpacity>
                  </View>
                  <View style={styles.viewPrice}>
                    <Text style={styles.price}>{precio}€</Text>
                  </View>
                </View>
            </View>
          </View>

          <View style={styles.flight}>
            <View>
              <Text style={styles.headerDetails}>Otros detalles</Text>
              <View style={{flex: 5, height:2, width:275, backgroundColor: 'black'}}/>
              <Text></Text>  
              <Text>Fecha de salida:                    Fecha de llegada:</Text>
              <Text>   {fechaSalida}                             {fechaLlegada}</Text>
              <Text></Text>
              <Text>Hora de salida:                      Hora de llegada:</Text>
              <Text>         {horaSalida}                                         {horaLlegada}</Text>
              <Text></Text>
              <Text style={{textAlign:'center'}}>Asiento: {asiento}</Text>
              <TouchableOpacity onPress={() => {this.showAirline(todo.todo.airline)}}>
                <Image style={styles.imageAirline} 
                  source={{
                    uri: airline}}
                />
              </TouchableOpacity>
              <Image style={styles.imageQR} 
                  source={require('nano_fly/assets/qr.png')}
                />
            </View>
          </View>
        </View>
      );
      
        const renderItem = ({ item }) => (
          <Item 
            id={item.id}
            aeropuertoSalida={item.todo.airportOrigin}
            fechaSalida={item.todo.dayExit}
            horaSalida={item.todo.hourExit}
            aeropuertoLlegada={item.todo.airportDestine}
            fechaLlegada={item.todo.dayArrive} 
            horaLlegada={item.todo.hourArrive}
            precio={item.todo.price}
            asiento={item.todo.seat}
            airline={item.todo.airline.image}/>
        );

        return (
          <View style={styles.container}>
            <SafeAreaView >
              <FlatList
                data={flight}
                renderItem={renderItem}
                keyExtractor={todo => todo.todo.id}
              />
            </SafeAreaView>
            <TouchableOpacity style={styles.button}
              onPress={() => {this.booking(todo.todo.airportDestine.city)}}>{/**fkgjlñ */}
            <View>
              <Text style={styles.textButton}>Reservar   ✈️ </Text>
            </View>
          </TouchableOpacity> 
          </View>
        );
    }
}
const styles = StyleSheet.create({
    container: {
      flex: 1,
      backgroundColor: 'rgba(190,21,190, 0.5)',
      paddingTop:"5%",
    },
    direction:{
      width: "100%",
      flexDirection: "row",
      alignItems: "center"
    },
    viewLocation:{
      width:"80%"
    },
    viewPrice:{ 
      width:"20%"
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
      borderColor: '#7a42f4',
      borderWidth: 1,
      backgroundColor:'green',
      color:"white",
      borderRadius:20,
      paddingLeft:15
   },
   button:{
     alignItems:"center",
     backgroundColor:"green",
     borderRadius:20,
     textAlign:"center",
     height:40,
     marginHorizontal:60,
     marginTop:20
   },
   textButton:{
     fontSize:28,
     color:"white",
   },
   imageAirline:{
     width:150,
     height:50,
     alignSelf:"center"
   },
   imageQR:{
     width:200,
     height:200,
     alignSelf:"center"
   },
   flight:{
    backgroundColor:"white",
    marginHorizontal:20,
    borderRadius:20,
    padding:20,
    paddingTop:10,
    flexDirection:"row"
  },
  header:{
    textAlign:"center",
    color:"blue",
    fontSize:30,
    fontStyle:"italic",
    fontWeight:"bold"
  },
  headerDetails:{
    textAlign:"center",
    color:"blue",
    fontSize:20,
    fontStyle:"italic"
  },
  price:{
    fontWeight:"bold"
  }
  }); 

  /* esto es para cogerlo de la API */
/*import React, { Component } from 'react';
import { ActivityIndicator, FlatList, Text, View } from 'react-native';

export default class TicketFlight extends Component {
  constructor(props) {
    super(props);

    this.state = {
      data: [],
      isLoading: true
    };
  }

  async getMovies() {
    try {
      const response = await fetch('https://reactnative.dev/movies.json');
      const json = await response.json();
      this.setState({ data: json.movies });
    } catch (error) {
      console.log(error);
    } finally {
      this.setState({ isLoading: false });
    }
  }

  componentDidMount() {
    this.getMovies();
  }

  render() {
    const { data, isLoading } = this.state;

    return (
      <View style={{ flex: 1, padding: 24 }}>
        {isLoading ? <ActivityIndicator/> : (
          <FlatList
            data={data}
            keyExtractor={({ id }, index) => id}
            renderItem={({ item }) => (
              <Text>{item.id}, {item.title}, {item.releaseYear}</Text>
            )}
          />
        )}
      </View>
    );
  }
};*/