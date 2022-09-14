import React from "react";
import Item from "./Item";

export default class Items extends React.Component {


    constructor(props) {
        super(props);

        this.state = [
            {id:1, text: '', count:0}
        ];
    }

    render() {
        return (
            <>
                <Item/>
                <Item/>
                <Item/>
            </>
        );
    }
}