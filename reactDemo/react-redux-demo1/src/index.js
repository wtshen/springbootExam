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
import createStore from './store'
import { Provider } from './react-redux'
import themeReducer from './reducer/reducer'

const store = createStore(themeReducer)

ReactDOM.render(
    <Provider store={store}>
        <App />
    </Provider>, document.getElementById('root'));