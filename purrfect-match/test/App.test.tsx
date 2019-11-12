
import React from 'react';
import ReactDOM from 'react-dom';
import renderer from 'react-test-renderer';
import { App } from 'App';

test("Renders correctly", () => {
    const app = renderer.create(<App />);
    expect(app.toJSON()).toMatchSnapshot();
});
