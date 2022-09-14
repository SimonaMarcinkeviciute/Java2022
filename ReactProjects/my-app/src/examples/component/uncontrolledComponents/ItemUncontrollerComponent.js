import React from "react";
//nekontroliuojami nenaudoja state
export default class ItemUncontrollerComponent extends React.Component {

    constructor(props) {
        super(props);

        //sukuriam rysi su inputu
        this.input = React.createRef();
    }

    change = (event) => {
        console.log('event.target.value', event.target.value);
        console.log('this.input.current.value', this.input.current.value);
    }

    render() {
        return(
            <>
                <input ref={this.input} onChange={this.change}/>

            </>
        );
    }
}