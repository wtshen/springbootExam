import { bookSearch } from './bookAction';
import {
    REQUEST_HEADER,
    actionCreator,
    dispatchAction
} from './constdata.js';

export function mapDispatchToProps(dispatch) {
    return {
        bookSearch: (param) => {
            bookSearch(param, dispatch)
        }
    }
}