import React from 'react';
import ReactDOM from 'react-dom';
import { configure, shallow, ShallowWrapper } from 'enzyme';
import Adapter from 'enzyme-adapter-react-16';
import { ContactPage } from 'ContactPage';
import { Input, Select, Message, Send } from 'inputBoxes';
import { Api } from 'Api';

configure({ adapter: new Adapter() });

jest.mock("Api");
jest.mock("inputBoxes");

let wrapper: ShallowWrapper<any, any, any>;
beforeEach(() => {
    wrapper = shallow(<ContactPage />);
});

test("Renders correctly", () => {
    expect(wrapper).toMatchSnapshot();

    // Setup second snapshot (with errors shown)
    wrapper.setState({
        firstName: "",
        lastName: "",
        subject: "",
        email: "",
        shelterEmployee: "",
        message: ""
    });
    expect(wrapper).toMatchSnapshot();
});

test("Submits correct information", () => {
    // Add some mock information. 
    wrapper.setState({
        firstName: "mockName",
        lastName: "mockLast",
        subject: "mockSubj",
        email: "mockEmail@website.com",
        shelterEmployee: "No",
        message: "mockMessage"
    });
    // Setup response from Api call
    (Api.submitContactInfo as jest.MockedFunction<() => Promise<void>>).mockReturnValueOnce(Promise.resolve());

    // Click submit button
    expect(wrapper.find(Send).props().onclick).not.toBeUndefined();
    // @ts-ignore: We know onclick() is defined.
    wrapper.find(Send).props().onclick();

    // At this point, Api.submitContactInfo() should have been called with our provided data.
    expect(Api.submitContactInfo).toHaveBeenCalledWith("mockName", "mockLast", "mockSubj", "mockEmail@website.com", "No", "mockMessage");
});

test("Information %s propogates to page correctly", () => {
    // Given an element and the specific field, this checks if changing that element updates the field
    function checkPropagation(onchange: ((newVal: string) => void) | undefined, field: keyof ContactPage["state"]) {
        // Make sure not undefined
        expect(onchange).not.toBeUndefined();
        // Since not undefined, we're safe to cast that away and call it.
        (onchange as (newVal: string) => void)("updatedValue-" + field);
        // Verify that the main component updated
        expect(wrapper.state(field)).toBe("updatedValue-" + field);
    }

    // Input box checks
    checkPropagation(wrapper.find(Input).at(0).props().onchange, "firstName");
    checkPropagation(wrapper.find(Input).at(1).props().onchange, "lastName");
    checkPropagation(wrapper.find(Input).at(2).props().onchange, "subject");
    checkPropagation(wrapper.find(Input).at(3).props().onchange, "email");

    // Dropdown check
    checkPropagation(wrapper.find(Select).at(0).props().onchange, "shelterEmployee");

    // Text area check
    checkPropagation(wrapper.find(Message).at(0).props().onchange, "message");
});

test("fillAndValidateField fills undefined field with \"\" and returns false", () => {
    expect(wrapper.instance().fillAndValidateField("firstName")).toBeFalsy();
    expect(wrapper.state("firstName")).toBe("");
});

test("fillAndValidateField returns false on empty string fields", () => {
    wrapper.setState({ firstName: "" });
    expect(wrapper.instance().fillAndValidateField("firstName")).toBeFalsy();
    expect(wrapper.state("firstName")).toBe("");
});

test("fillAndValidateField does not change filled fields and returns true", () => {
    wrapper.setState({ firstName: "mockFirst" });
    expect(wrapper.instance().fillAndValidateField("firstName")).toBeTruthy();
    expect(wrapper.state("firstName")).toBe("mockFirst");
});

test("handleSubmit does not make API call if validation fails", () => {
    wrapper.instance().fillAndValidateField = jest.fn()
        .mockReturnValueOnce(true)  // firstName
        .mockReturnValueOnce(false) // lastName
        .mockReturnValueOnce(true)  // subject
        .mockReturnValueOnce(true)  // email
        .mockReturnValueOnce(true)  // shelterEmploye
        .mockReturnValueOnce(true)  // message
    wrapper.instance().handleSubmit();

    expect(wrapper.instance().fillAndValidateField).toHaveBeenCalledTimes(6);
    expect(Api.submitContactInfo).not.toHaveBeenCalled();
});

test("checkField returns correct error message or nothing", () => {
    expect(wrapper.instance().checkField(undefined, "mockErr")).toBeUndefined();
    expect(wrapper.instance().checkField("mockData", "mockErr")).toBeUndefined();
    expect(wrapper.instance().checkField("", "mockErr")).toBe("mockErr");
});
