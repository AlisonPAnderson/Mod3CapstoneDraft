import { createSlice } from "@reduxjs/toolkit";

const tokenSlice = createSlice({
  name: "token",
  initialState: {
    token: undefined,
  },
  reducers: {
    addToken: (state, action) => {
      state.token = action.payload;
    },
  },
});

export const { addToken } = tokenSlice.actions;
export default tokenSlice.reducer;
