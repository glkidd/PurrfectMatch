import React from 'react';
import ReactDOM from 'react-dom';
import { configure, shallow, ShallowWrapper } from 'enzyme';
import Adapter from 'enzyme-adapter-react-16';
import { NavigationMenu } from 'NavigationMenu/NavigationMenu';

configure({ adapter: new Adapter() });

let wrapper: ShallowWrapper<any, any, any>;
beforeEach(() => {
    wrapper = shallow(<NavigationMenu />);
});



test("Renders correctly", () => {
    expect(wrapper).toMatchSnapshot();
    // Scroll
    wrapper.setState({ hasScrolled: true });
    expect(wrapper).toMatchSnapshot();
});

test("handleScroll updates correctly", () => {
    // This component uses the global "window" object to see the scroll of the page
    // Sadly, this isn't easy to work with as it's readonly, so we need to do a lot of setup
    // to be able to mock it. 
    let spy = jest.spyOn(window, 'addEventListener');
    let yVal = 0;
    Object.defineProperty(window, "pageYOffset", { get: () => yVal });

    // Mount the component. Since we shallow rendered this wasn't called.
    wrapper.instance().componentDidMount();
    let scrollCallback: any = spy.mock.calls[0][1]; // Second parameter passed in for first call to this function. Should be the scroll handler

    expect(scrollCallback).toBe(wrapper.instance().handleScroll);

    expect(wrapper.state("hasScrolled")).toBeFalsy();

    // Scroll to 50, 1 px away from changing
    yVal = 50;
    scrollCallback();
    expect(wrapper.state("hasScrolled")).toBeFalsy();

    // Scroll to 51
    yVal = 51;
    scrollCallback();
    expect(wrapper.state("hasScrolled")).toBeTruthy();

    // Scroll to 10
    yVal = 10;
    scrollCallback();
    expect(wrapper.state("hasScrolled")).toBeFalsy();
});
