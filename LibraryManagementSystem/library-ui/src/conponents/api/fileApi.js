import HTTP from "./index";

const uploadFile = (data) => HTTP.post('/files/metadata', data, {
    headers: {
        'Content-type': 'multipart/form-data'
    }
});

const updateFile = (data, fileId) => HTTP.put(`/files/metadata/${fileId}`, data, {
    headers: {
        'Content-type': 'multipart/form-data'
    }
});

export {
    uploadFile,
    updateFile
}