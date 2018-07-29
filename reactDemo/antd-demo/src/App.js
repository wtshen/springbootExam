import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import { Button } from 'antd';
import AdvancedSearchForm from './containers/AdvancedSearchForm';
import Grid from './containers/Grid';

class App extends Component {
  render() {
    return (
      <div className="App">
        <AdvancedSearchForm />
        <Grid />
      </div>
    );
  }
}

export default App;
