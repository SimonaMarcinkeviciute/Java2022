import React from "react";

export default class ClassHelloWorldComponent extends React.Component {


    constructor(props) {
        super(props);
        //pasiradom kompinento objekta
        this.state = {...props.user}
    }

    onChangeName = (event) => {
        //updatinam state komponente
        this.setState({
            name: event.target.value
        })
    }

    onChangeSecondName(event) {
        this.setState({
            surname: event.target.value
        });
    }



    render() {
        return (
            <>
                {/*atvaizduojam komponento state*/}
                <h1>{this.state.name}</h1>
                <h1>{this.state.surname}</h1>

                <div>
                    <input onChange={this.onChangeName} value={this.state.name}/>
                    <input onChange={event => this.onChangeSecondName(event)} value={this.state.surname}/>
                </div>
            </>
        )
    }
}