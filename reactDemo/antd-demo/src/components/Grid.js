import { Table, Icon, Divider } from 'antd';
import React, { Component } from 'react';
import { ReactDom } from 'react-dom';
import { connect } from 'react-redux';
import { mapStateToProps } from '../actions/mapStateToProps';
import { mapDispatchToProps } from '../actions/mapDispatchToProps';

class Grid extends Component {
    constructor(props){
        super(props)        
    }
    render() {
        const columns = [{
            title: 'Name',
            dataIndex: 'name',
            key: 'name',
            render: text => <a href="javascript:;">{text}</a>,
        }, {
            title: 'Age',
            dataIndex: 'age',
            key: 'age',
        }, {
            title: 'Address',
            dataIndex: 'address',
            key: 'address',
        }, {
            title: 'Action',
            key: 'action',
            render: (text, record) => (
                <span>
                    <a href="javascript:;">Action 一 {record.name}</a>
                    <Divider type="vertical" />
                    <a href="javascript:;">Delete</a>
                    <Divider type="vertical" />
                    <a href="javascript:;" className="ant-dropdown-link">
                        More actions <Icon type="down" />
                    </a>
                </span>
            ),
        }];

        const data = this.props.bookSearchResult;
        return (
            <div>
                <Table columns={columns} dataSource={data} />
            </div >
        );
    }
}

export default connect(mapStateToProps, mapDispatchToProps)(Grid);
