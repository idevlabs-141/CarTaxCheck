echo "--Clean Up--"
call mvn clean test

echo "--Tax Check Test----"
call mvn clean test -Dcucumber.plugin="json:cucumber-json-reports/cucumber-taxcheck.json"

echo "--Generate cucumber maven results --"
call mvn verify -DskipTests