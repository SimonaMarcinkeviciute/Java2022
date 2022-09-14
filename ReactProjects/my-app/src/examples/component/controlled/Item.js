import React from "react";

export default class Item extends React.Component {


    constructor(props) {
        super(props);

        this.state = {
            count: 0,
            text: ''
        }
    }

    addItem() {
        let  {count} = this.state;
        count += 1;
        this.setState({count});

    }

    clearItem() {
        this.setState({count: 0});
    }

    removeItem() {
        let  {count} = this.state;
        if(count > 0) {
            count -= 1;
            this.setState({count});
        }
    }

    getBadgeClass() {
        let badgeClass = 'badge text-bg-';
        const {count} = this.state;

        if(count >=  2 && count < 10) {
            badgeClass += 'warning';
        }else if (count > 10) {
            badgeClass += 'success';
        }else  {
            badgeClass += 'info';
        }

        return badgeClass;
    }

    onHandlingText = (event) => {
        const text = event.target.value;
        this.setState({text})
    }



    render() {
        return (
            <div class="container" >
            <div class="pt-5 col-3">

                <div className="input-group mb-3">
                    <span  className={this.getBadgeClass()}>{this.state.count}</span>
                    <input type="text" className="form-control" placeholder="Recipient's username"
                           aria-label="Recipient's username" aria-describedby="button-addon2" onChange={this.onHandlingText}/>
                        <button className="btn btn-outline-primaty" type="button" id="button-addon2" onClick={() => this.addItem()}>+</button>
                    <button className={this.state.count > 0 ? 'btn btn-outline-primaty' : 'btn btn-outline-danger disabled'} type="button" id="button-addon2" onClick={() => this.removeItem()}>-</button>
                </div>
            </div>
                {/*nerodo elemento kol netenkina salygos*/}
                {this.state.text.length > 0 && <span>{this.state.text}</span>}
            </div>
        )
    }
}