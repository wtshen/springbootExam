import { Form, Row, Col, Input, Button, Icon } from 'antd';
import '../App.css';
import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import { mapStateToProps } from '../actions/mapStateToProps';
import { mapDispatchToProps } from '../actions/mapDispatchToProps';
import { connect } from 'react-redux';

const FormItem = Form.Item;

const formItemLayout = {
    labelCol: { span: 5 },
    wrapperCol: { span: 15 }
};

class AdvancedSearchForm extends React.Component {
    handleSearch = () => {
        let queryParam = {
            pageIndex: 0,
            pageSize: 10,
            entityName: this.refs.id.input.value,
            propertyName: this.refs.name.input.value,
            propertyCode: this.refs.price.input.value,
            propertyValue: this.refs.owner_id.input.value
        }
        this.props.bookSearch({queryParam})
    }

    handleReset = () => {
        this.props.form.resetFields();
    }

    render() {
        return (
            <Form className="ant-advanced-search-form">
                <Row gutter={24}>
                    <Col span={8}>
                        <FormItem label="编号" {...formItemLayout} >
                            <Input placeholder="请输入书籍编号" ref="id" />
                        </FormItem>
                    </Col>
                    <Col span={8}>
                        <FormItem label="名称" {...formItemLayout}>
                            <Input placeholder="请输入书籍名称" ref="name" />
                        </FormItem>
                    </Col>
                </Row>
                <Row gutter={24}>
                    <Col span={8}>
                        <FormItem label="价格"  {...formItemLayout}>
                            <Input placeholder="请输入价格" ref="price" />
                        </FormItem>
                    </Col>
                    <Col span={8}>
                        <FormItem label="借阅者编号"  {...formItemLayout}>
                            <Input placeholder="请输入借阅者编号" ref="owner_id" />
                        </FormItem>
                    </Col>
                </Row>
                <FormItem wrapperCol={{ span: 10, offset: 10 }}>
                    <Button type="primary" onClick={() => { this.handleSearch(); }}>
                        确定
                    </Button>
                    <Button onClick={this.handleReset}>
                        清除
                    </Button>
                </FormItem>
            </Form>
        );
    }
}
export default connect(mapStateToProps, mapDispatchToProps)(AdvancedSearchForm);