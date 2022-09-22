import HTTP from "./index";

const uploadFile = (data) => HTTP.post('/files/metadata', data, {
    headers: {
        'Content-type': 'multipart/form-data'
    }
});

const getFile = (fileName) => HTTP.get(`/files/${fileName}`, {
    headers:{
        'Content-type': ''
    }
});

export {
    uploadFile,
    getFile
}