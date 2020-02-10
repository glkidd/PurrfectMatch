import React from 'react';
import ReactDOM from 'react-dom';
import { configure, shallow, ShallowWrapper } from 'enzyme';
import Adapter from 'enzyme-adapter-react-16';
import { Input, Select, Message, Send } from 'inputBoxes';

configure({ adapter: new Adapter() });


describe("Input tests", () => {
    let wrapper: ShallowWrapper<any, any, any>;
    beforeEach(() => {
        wrapper = shallow(<Input prompt="mockPrompt" error="" onchange={jest.fn()} />);
    });

    test("Snapshot test", () => {
        expect(wrapper).toMatchSnapshot();
        wrapper.setProps({ error: "mockErr " });
        expect(wrapper).toMatchSnapshot();
    });

    test("Updates correctly", () => {
        wrapper.instance().handleChange({ target: { value: "mockNewVal" } });
        expect(wrapper.instance().props.onchange).toHaveBeenCalledWith("mockNewVal");
    });
});

describe("Select tests", () => {
    let wrapper: ShallowWrapper<any, any, any>;
    beforeEach(() => {
        wrapper = shallow(<Select prompt="mockPrompt" options={["op1", "op2"]} error="" onchange={jest.fn()} />);
    });

    test("Snapshot test", () => {
        expect(wrapper).toMatchSnapshot();
        wrapper.setProps({ error: "mockErr " });
        expect(wrapper).toMatchSnapshot();
    });

    test("Updates correctly", () => {
        wrapper.instance().handleChange({ target: { value: "op2" } });
        expect(wrapper.instance().props.onchange).toHaveBeenCalledWith("op2");
    });
});

describe("Message tests", () => {
    let wrapper: ShallowWrapper<any, any, any>;
    beforeEach(() => {
        wrapper = shallow(<Message prompt="mockPrompt" error="" onchange={jest.fn()} />);
    });

    test("Snapshot test", () => {
        expect(wrapper).toMatchSnapshot();
        wrapper.setProps({ error: "mockErr " });
        expect(wrapper).toMatchSnapshot();
    });

    test("Updates correctly", () => {
        wrapper.instance().handleChange({ target: { value: "mockNewVal" } });
        expect(wrapper.instance().props.onchange).toHaveBeenCalledWith("mockNewVal");
    });
});

describe("Send tests", () => {
    let wrapper: ShallowWrapper<any, any, any>;
    beforeEach(() => {
        wrapper = shallow(<Send onclick={jest.fn()} />);
    });

    test("Snapshot test", () => {
        expect(wrapper).toMatchSnapshot();
        wrapper.setProps({ error: "mockErr " });
        expect(wrapper).toMatchSnapshot();
    });

    test("Updates correctly", () => {
        wrapper.instance().handleSubmit();
        expect(wrapper.instance().props.onclick).toHaveBeenCalledWith();
    });
});