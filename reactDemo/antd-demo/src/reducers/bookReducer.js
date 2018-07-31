import { combineReducers } from 'redux';
function bookSearchResultReduce(state = [], action) {
    if (action.type === "bookSearchResultReduce") {
        return [ ...action.data ]
    }
    return state;
    
}

let reduces = {
    bookSearchResult: bookSearchResultReduce
}
const bookReducer = combineReducers(reduces)


export default bookReducer;