
import React, { Component } from 'react';
import '../App.css';
import AdvancedSearchForm from './AdvancedSearchForm';
import Grid from './Grid';

class bookList extends Component {
  render() {
    return (
      <div className="App">
        <AdvancedSearchForm />
        <Grid />
      </div>
    );
  }
}

export default bookList;
