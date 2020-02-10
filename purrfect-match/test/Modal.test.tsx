import React from 'react';
import ReactDOM from 'react-dom';
import { configure, shallow, ShallowWrapper } from 'enzyme';
import Adapter from 'enzyme-adapter-react-16';
import { Modal } from 'Modal';

configure({ adapter: new Adapter() });

let wrapper: ShallowWrapper<any, any, any>;
beforeEach(() => {
    wrapper = shallow(<Modal display={true} onClose={jest.fn()}><div>mockContent</div></Modal>);
});

test("Renders correctly", () => {
    expect(wrapper).toMatchSnapshot();
    wrapper.setProps({ display: false });
    expect(wrapper).toMatchSnapshot();
});

test("Closes when clicked", () => {
    let stopPropagation = jest.fn();
    wrapper.find(".modal").simulate("click", { stopPropagation: stopPropagation });
    expect(stopPropagation).toHaveBeenCalled();

    wrapper.find(".modal-overlay").simulate("click", {});
    expect(wrapper.instance().props.onClose).toHaveBeenCalled();

    wrapper.find(".modal-close").simulate("click", {});
    expect(wrapper.instance().props.onClose).toHaveBeenCalledTimes(2);
});