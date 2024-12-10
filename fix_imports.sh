#!/bin/bash

# Define the base directory
BASE_DIR="c:/Users/FAIR/OneDrive/Desktop/Por ordenar/Repositories/moview/service/src/main/java/pe/edu/certus/logic/provider"

# List of entity types
ENTITIES=("user" "movie" "projection" "orden" "snack" "ticket" "card")

# Iterate through each entity type
for entity in "${ENTITIES[@]}"; do
    # Path to the Manager file
    MANAGER_FILE="${BASE_DIR}/${entity}/${entity^}Manager.java"
    
    # Perform sed replacements
    sed -i 's/pe\.edu\.certus\.persistence\.'${entity}'\./pe.edu.certus.repository.'${entity}'./g' "$MANAGER_FILE"
    sed -i 's/pe\.edu\.certus\.entities\.'${entity}'\./pe.edu.certus.entities.'${entity}'./g' "$MANAGER_FILE"
done
