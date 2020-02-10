import React from 'react';
import ReactDOM from 'react-dom';
import { configure, shallow, ShallowWrapper } from 'enzyme';
import Adapter from 'enzyme-adapter-react-16';
import { CompactView } from 'CompactView';
import { Modal } from 'Modal';

configure({ adapter: new Adapter() });

jest.mock("Modal");

let wrapper: ShallowWrapper<any, any, any>;
beforeEach(() => {
    let CVinfo = {name: "mockName", image: "mockImg", age: "mockAge", storyText: "mockStoryText", breed: "mockBreed", gender: "mockGender", adoptionDate: "mockDate", owner: "mockOwner"};
    wrapper = shallow(<CompactView info={CVinfo} />);
});

test("Snapshot test", () => {
    expect(wrapper).toMatchSnapshot();
});

test("Modal opens when clicked", () => {
    // This needs to be split like this due to inconsistent type definitions with enzyme. 
    // When using wrapper.find(Modal) it knows it'l get a Modal so can fill in the props type
    // correctly. However, since button is a react component we need to search by string, leaving
    // props empty without this cast;
    let button = wrapper.find("button") as any;
    button.props().onClick();

    expect(wrapper.find(Modal).props().display).toBeTruthy();
});

test("Modal closes when closed", () => {
    wrapper.setState({modalOpen: true});

    expect(wrapper.find(Modal).props().display).toBeTruthy();

    wrapper.find(Modal).props().onClose();

    expect(wrapper.find(Modal).props().display).toBeFalsy();
});
