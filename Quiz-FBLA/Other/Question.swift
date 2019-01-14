//
//  Question.swift
//  FBLA Quiz 4
//
//  Created by Arez Khidr on 1/8/19.
//  Copyright © 2019 Arez Khidr. All rights reserved.
//

import Foundation
//Custom Question Class that is accessed in arrays
class Question {
    let question: String
    let optionA: String
    let optionB: String
    let optionC: String
    let correctAnswer: Int
    
    init(questionText: String, choiceA: String, choiceB: String, choiceC: String, answer: Int){
        question = questionText
        optionA = choiceA
        optionB = choiceB
        optionC = choiceC
        correctAnswer = answer
    }
}

class QuestionHistory {
    let question: String
    let optionA: String
    let optionB: String
    let optionC: String
    let correctAnswer: Int
    
    init(questionText: String, choiceA: String, choiceB: String, choiceC: String, answer: Int){
        question = questionText
        optionA = choiceA
        optionB = choiceB
        optionC = choiceC
        correctAnswer = answer
    }
}
