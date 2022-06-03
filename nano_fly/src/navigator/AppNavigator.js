import React, { Component } from 'react';
import { NavigationContainer } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import {
  Text,
  TouchableOpacity,
  View,
  StyleSheet,
  Alert,
  Image
} from "react-native";

import MainScreen from "nano_fly/src/screens/Main"
import ListFlight from "nano_fly/src/screens/ListFlight"
import TicketFlight from "nano_fly/src/screens/TicketFlight"
const Stack = createNativeStackNavigator();

class App extends Component {
  render() {
    return (
      <NavigationContainer>
        <Stack.Navigator initialRouteName="Home">
          <Stack.Screen name="Home" component={MainScreen}
            options={{
              title: 'NANO FLY',
              headerStyle: {
                backgroundColor: '#000',
              },
              headerTintColor: '#fff',
              headerTitleStyle: {
                fontWeight: 'bold',
              },
            }}
          />
          <Stack.Screen name="Flight" component={ListFlight}
            options={{
              title: 'Lista de vuelos',
              headerStyle: {
                backgroundColor: '#000',
              },
              headerTintColor: '#fff',
              headerTitleStyle: {
                fontWeight: 'bold',
              },
            }}
          />
          <Stack.Screen name="Ticket" component={TicketFlight}
            options={{
              title: 'Billete de avión',
              headerStyle: {
                backgroundColor: '#000',
              },
              headerTintColor: '#fff',
              headerTitleStyle: {
                fontWeight: 'bold',
              },
            }}
          />
        </Stack.Navigator>
      </NavigationContainer>
    );
  }
}

export default App;