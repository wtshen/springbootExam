import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import { Button } from 'antd';
import AdvancedSearchForm from './containers/AdvancedSearchForm';

class App extends Component {
  render() {
    return (
      <div className="App">
        <AdvancedSearchForm />
        {/* <Button type='primary'>Button</Button> */}
      </div>
    );
  }
}

export default App;
