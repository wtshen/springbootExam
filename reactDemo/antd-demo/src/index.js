import './index.css';
import bookList from './components/bookList';
import bookReducer from './reducers/bookReducer';

import React from 'react'
import { render } from 'react-dom'
import { createStore } from 'redux'
import { Provider } from 'react-redux'
import { Link, Route, Switch } from 'react-router-dom';
import { BrowserRouter, HashRouter } from 'react-router-dom';

/* ReactDOM.render(<App />, document.getElementById('root'));
registerServiceWorker(); */


let mountNode = document.getElementById('root');
let store = {};//createStore(bookReducer);
render(
    <Provider store={store}>
        <HashRouter >
            <div>
                <Route path="/bookList" component={bookList} />
            </div>
        </HashRouter>
    </Provider>, mountNode)
if (window.location.href.endsWith("index#/")) {
    window.location.href = window.location.href + "bookList"
}
