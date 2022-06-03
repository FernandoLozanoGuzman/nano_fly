import React from "react";
import {
  Text,
  TouchableOpacity,
  View,
  StyleSheet,
  SectionList,
  Image
} from "react-native";

/** lo que se ve por pantalla */
const FlightList = ({ allFlight, otherFlight, origin, destine, showFlight }) => {
  renderItem = flight => (
    <TouchableOpacity
      style={styles.listItem}
      key={flight.id}
      onPress={() => showFlight(flight)}
    >
      <View style={styles.flight}>
            <View style={styles.flightData}>
                <Text>Aeropuerto de salida: {flight.airportOrigin.nameAirport}</Text>
                <Text>Fecha de salida: {flight.dayExit}</Text>
                <Text>Hora de salida: {flight.hourExit}</Text>
                <Text></Text>
                <Text>Aeropuerto de llegada: {flight.airportDestine.nameAirport}</Text>
                <Text>Fecha de llegada: {flight.dayArrive}</Text>
                <Text>Hora de llegada: {flight.hourArrive}</Text>
            </View>
            <View style={styles.flightPrice}>
                <Text>  Precio:</Text>
                <Text style={styles.price}>{flight.price}€</Text>
            </View>
        </View>
    </TouchableOpacity>
  );

  renderSeparator = () => {
    return <View style={styles.separator} />;
  };

  renderEmptyComponent = () => (
    <View style={styles.emptyList}>
      <Text style={styles.emptyText}>No hay vuelos relacionados con la busqueda</Text>
      <Image
        style={styles.emptyImage}
        source={require("nano_fly/assets/empty.png")}
      />
    </View>
  );

  /**nombre de las listas */
  renderSectionHeader = ({ section: { title, data } }) => (
    <View style={styles.sectionHeader}>
      <Text>
        {title} ({data.length})
      </Text>
    </View>
  );

  /** obtienes las listas */
  getSectionData = () => {
    if (allFlight && allFlight.length) {
      return [
        {
          title: "Quiero ir desde "+(JSON.stringify(origin))+" hasta "+(JSON.stringify(destine)),
          data: allFlight
        },
        {
          title: "Otros vuelos con destino a "+(JSON.stringify(destine)),
          data: otherFlight
        }
      ];
    }
    return [];
  };

  return (
    <SectionList
      style={styles.container}
      sections={getSectionData()}
      keyExtractor={flight => flight.id}
      renderItem={({ item }) => renderItem(item)}
      renderSectionHeader={renderSectionHeader}
      ItemSeparatorComponent={renderSeparator}
      ListEmptyComponent={renderEmptyComponent}
      stickySectionHeadersEnabled={true}
    />
  );
};

export default FlightList;

const styles = StyleSheet.create({
  container: {
    width: "100%",
    backgroundColor: 'rgba(190,21,190, 0.5)',
  },
  listItem: {
    margin: 5,
    padding: 5,
    width: "100%",
    flexDirection: "row",
    alignItems: "center"
  },
  bullet: {
    width: "10%"
  },
  emptyList: {
    flex: 1,
    justifyContent: "center",
    alignItems: "center",
  },
  emptyText:{    
    fontSize:30,
    paddingVertical:30,
    textAlign:"center"
  },
  emptyImage: {
    width: 50,
    height: 50,
  },
  separator: {
    height: 1,
    backgroundColor: "#CED0CE",
  },
  sectionHeader: {
    backgroundColor: "#ddd",
    padding: 10
  },
 flight:{
   backgroundColor:"white",
   marginHorizontal:20,
   borderRadius:25,
   padding:20,
   flexDirection:"row"
 },
 flightData:{
    width:"80%"
 },
 flightPrice:{
    width:"20%"
 },
 price:{
    fontWeight:"bold",
    textAlign:"center"
 }
});