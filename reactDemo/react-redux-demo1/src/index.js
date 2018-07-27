/* import React from 'react';
import ReactDOM from 'react-dom';
import './css/index.css';
import App from './component/App';
import registerServiceWorker from './registerServiceWorker';

ReactDOM.render(<App />, document.getElementById('root'));
registerServiceWorker();
 */

import React from 'react';
import ReactDOM from 'react-dom';
import './css/index.css';
import App from './component/App';
import { createStore } from 'redux'
import { Provider } from 'react-redux'
import themeReducer from './reducer/reducer'

//const store = createStore(themeReducer)

const store = createStore(
    themeReducer,
    window.__REDUX_DEVTOOLS_EXTENSION__ && window.__REDUX_DEVTOOLS_EXTENSION__()
);

ReactDOM.render(
    <Provider store={store}>
        <App />
    </Provider>, document.getElementById('root'));