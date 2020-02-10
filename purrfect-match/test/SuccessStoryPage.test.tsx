import React from 'react';
import ReactDOM from 'react-dom';
import { configure, shallow, ShallowWrapper } from 'enzyme';
import Adapter from 'enzyme-adapter-react-16';
import { SuccessStoryPage } from 'SuccessStoryPage';

configure({ adapter: new Adapter() });

let wrapper: ShallowWrapper<any, any, any>;
beforeEach(() => {
    wrapper = shallow(<SuccessStoryPage />);
});

test("Snapshot test", () => {
    expect(wrapper).toMatchSnapshot();
});

test.todo("Gets stories from api call");
test.todo("Page change fetches new stories correctly");