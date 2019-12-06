import React from 'react';
import ReactDOM from 'react-dom';
import { configure, shallow, ShallowWrapper } from 'enzyme';
import Adapter from 'enzyme-adapter-react-16';
import { Card } from 'HomePage/Card';

configure({ adapter: new Adapter() });

let wrapper: ShallowWrapper<any, any, any>;
beforeEach(() => {
    wrapper = shallow(<Card image="mockImage" />);
});

test("Renders correctly", () => {
    expect(wrapper).toMatchSnapshot();
});