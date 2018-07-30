const DEFAULT_BOOK_QUERY = {
    id: '',
    name: '',
    price: '',
    owner_id: ''
}
function bookSearch(state = DEFAULT_BOOK_QUERY, action) {
    if (action.type === "bookSearch") {
        return { ...action.data }
    }
    return state;
}

let bookReducer = {
    bookSearch: bookSearch
}

export default bookReducer;