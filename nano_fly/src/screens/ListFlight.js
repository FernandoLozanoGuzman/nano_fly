import React, { Component } from 'react'
import FlightList from '../component/ListTouchable';

export default class ListFlight extends Component {
  constructor(props) {
    super(props);

    this.state = {
      listFlightData: [],
      listOtherFlightData: [],
      isLoading: true,
      origin: props.route.params.origin,
      destine: props.route.params.destine
    }
  }

  cambioPagina = flight => {
    this.props.navigation.navigate("Ticket", {
      flight
    })
  }
  
  componentDidMount() {
    this.getFlight();
  }

  async getFlight() {
    try {
      const response = await fetch('https://shielded-meadow-41175.herokuapp.com/flight/airports?airportOrigin=' + (this.state.origin) + '&airportDestine=' + (this.state.destine));
      const json = await response.json();
      const responseOther = await fetch('https://shielded-meadow-41175.herokuapp.com/flight/airportDestine?airportOrigin=' + (this.state.origin) + '&airportDestine=' + (this.state.destine));
      const jsonOther = await responseOther.json();
      this.setState({ listFlightData: json, listOtherFlightData: jsonOther });
    } catch (error) {
      console.log(error);
    } finally {
      this.setState({ isLoading: false });
    }
  }

  render() {
    const { origin, destine, listFlightData, listOtherFlightData } = this.state;
    return (
      <FlightList
        allFlight={listFlightData}
        otherFlight={listOtherFlightData}
        origin={origin}
        destine={destine}
        showFlight={this.cambioPagina}
      />
    );
  }
}