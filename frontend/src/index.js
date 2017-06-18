import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import registerServiceWorker from './registerServiceWorker';
import { Provider } from 'react-redux';
import thunkMiddleware from 'redux-thunk';
import logger from 'redux-logger'
import { createStore, applyMiddleware } from 'redux';
import reduc from './reducers/reducer';

let store = createStore(reduc, applyMiddleware(thunkMiddleware,logger));

ReactDOM.render(
    <Provider store={store}>    
        <App />
    </Provider>

    , document.getElementById('root'));
registerServiceWorker();
