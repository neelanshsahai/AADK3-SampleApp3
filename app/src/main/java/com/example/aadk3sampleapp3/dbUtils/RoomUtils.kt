package com.example.aadk3sampleapp3.dbUtils

// 1. Entity --> Table [user1, user2, user3 ....]

// Data Access Object --> interface that is used by room to identify what to do to on which function call
// 2. DAO --> CRUD Operations - Create | Read | Update | Delete

// 3. Database --> Reference to your local db with which you access everything

// 4. TypeConverter --> SQL (INTEGER, CHARECTER, TEXT) data class Person

/*
Person(name = "ABC", age=25, contact="9876543210")
JSON String = "{"name": "ABC", "age": 25, "contact": "9876543210"}"
 */

// From DataClass to JsonString --> When Storing Data
// From JsonString to DataClass --> When Fetching/Reading Data

// Database -> SQLite
// A lot of code to CRUD

// TODO: Copy the Social Apps UI into a new Project
// TODO: Add an Auth Activity and setup Firebase Authentication
// Auth Page
// Use Firestore
// Create Posts
// User Profile
// Like and Comment
// Push and Pull data from Firestore

