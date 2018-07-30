const REQUEST_HEADER = {
    'Accept': 'application/json',
    'Content-Type': 'application/json'
}


const actionCreator = function (type, data) {
    return {
        type: type,
        data: data
    }
}

const dispatchAction = function (dispatch, actionType, actionData) {
    dispatch(actionCreator(actionType, actionData));
}
export { REQUEST_HEADER, actionCreator, dispatchAction }